package de.uni_mannheim.informatik.dws.ontmatching.matchingeval.evaluator.metric.alignmentanalyzer;

import de.uni_mannheim.informatik.dws.ontmatching.matchingeval.ExecutionResult;
import de.uni_mannheim.informatik.dws.ontmatching.yetanotheralignmentapi.CorrespondenceRelation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * The AlignmentAnalyzerResult is the output of the {@link AlignmentAnalyzerMetric}.
 * @author Jan Portisch
 */
public class AlignmentAnalyzerResult {
    /**
     * Logger for this class.
     */
    private static Logger LOGGER = LoggerFactory.getLogger(AlignmentAnalyzerResult.class);
    


    /**
     * Execution result that was analyzed.
     */
    private ExecutionResult executionResult;

    /**
     * The minimum confidence score that is used in the given alignment.
     */
    private double minimumConfidence;

    /**
     * The maximum confidence score that is used in the given alignment.
     */
    private double maximumConfidence;

    /**
     * The distribution of relations in the given mapping.
     * Example: EQUIVALENCE → 40
     */
    private Map<CorrespondenceRelation, Integer> frequenciesOfRelations;

    /**
     * Indicates whether only resources of the same type are matched e.g. classes with
     * classes and object properties with object properites.
     */
    private boolean isHomogenousAlingment;

    /**
     * This data structure keeps track of the frequency of different mapping types,
     * e.g. "class - class" → 55
     */
    private Map<String, Integer> frequenciesOfMappingTypes;
    
    /**
     * How many URIs are in correct position which means entity one in correspondence is found in source ontology
     * and entity two is found in target ontology.
     */
    private int urisCorrectPosition;
    
    /**
     * How many URIs are NOT in correct position which means entity one in correspondence is found in target ontology
     * and entity two is found in source ontology.
     */
    private int urisIncorrectPosition;
    
    /**
     * Which URIs in the alignment are not found in source nor target ontology.
     */
    private List<String> urisNotFound;
    
    /**
     * Which arity occurs how often
     */
    private Map<Arity, Integer> arityCounts;
    
    /**
     * Constructor
     * @param executionResult Execution result that was analyzed.
     * @param minimumConfidence The minimum confidence score that is used in the given alignment.
     * @param maximumConfidence The maximum confidence score that is used in the given alignment.
     * @param frequenciesOfRelations The distribution of relations in the given mapping.
     * @param isHomogenousAlingment Indicator on whether only resources of the same type are matched.
     * @param frequenciesOfMappingTypes Frequency of different mapping types.
     */
    AlignmentAnalyzerResult(ExecutionResult executionResult, double minimumConfidence,
                            double maximumConfidence, Map<CorrespondenceRelation, Integer> frequenciesOfRelations,
                            boolean isHomogenousAlingment, Map<String, Integer> frequenciesOfMappingTypes,
                            int urisCorrectPosition, int urisIncorrectPosition, List<String> urisNotFound, Map<Arity, Integer> arityCounts){
        this.executionResult = executionResult;
        this.minimumConfidence = minimumConfidence;
        this.maximumConfidence = maximumConfidence;
        this.frequenciesOfRelations = frequenciesOfRelations;
        this.isHomogenousAlingment = isHomogenousAlingment;
        this.frequenciesOfMappingTypes = frequenciesOfMappingTypes;
        this.urisCorrectPosition = urisCorrectPosition;
        this.urisIncorrectPosition = urisIncorrectPosition;
        this.urisNotFound = urisNotFound;
        this.arityCounts = arityCounts;
    }

    @Override
    public String toString() {
        return getReportForAlignment();
    }


    public String getErroneousReport() {
        StringBuilder sb = new StringBuilder();
        if(this.isSwitchOfSourceTargetBetter()){
            sb.append("Need switch: ").append(this.executionResult);
        }
            
        if(this.getUrisNotFound().isEmpty() == false){
            sb.append("Not found: ").append(this.getUrisNotFound());
        }
        return sb.toString();
    }
    
    public void logReport() {
        LOGGER.info(getReportForAlignment());
    }

    public void logErroneousReport() {
       String error = getErroneousReport();
       if(error.length() != 0)
            LOGGER.error(error);
    }
    
    /**
     * Get a textual report of the alignment as String.
     * @return Textual report.
     */
    public String getReportForAlignment() {
        StringBuilder result = new StringBuilder();
        
        // header
        result.append(String.format("Alignment Report for %s on track %s for test case \n\n", 
                executionResult.getMatcherName(),
                executionResult.getTestCase().getTrack().getName(),
                executionResult.getTestCase().getName()));
        
        // base line
        result.append("Number of correspondences: " + this.getNumberOfCorrespondences() + "\n\n");

        // heterogeneity
        if(this.isHomogenousAlingment) {
            result.append("The mapping is homogenous.\n\n");
        } else {
            result.append("The mapping is heterogenous.\n\n");
        }

        // mapping type distribution
        result.append("Distribution of mapping types:\n");
        for (String key : this.getFrequenciesOfMappingTypes().keySet()) {
            result.append(key + " (" + this.getFrequenciesOfMappingTypes().get(key) + ")\n");
        }
        result.append("\n");

        // relations
        if(isAlwaysEqualityRelation()) {
            result.append("All correspondences are made up of equivalence relations.\n");
        } else {
            result.append("Distribution of mapping relations:\n");
            for (CorrespondenceRelation key : this.getFrequenciesOfRelations().keySet()) {
                result.append(key + " (" + this.getFrequenciesOfRelations().get(key) + ")\n");
            }
            result.append("\n");
        }
        result.append("\n");

        if(isConfidenceScoresAreAlwaysOne()){
            result.append("The confidence of all correspondences is 1.0.\n\n");
        } else {
            result.append("The minimum confidence is " + this.getMinimumConfidence() + "\n");
            result.append("The maximum confidence is " + this.getMaximumConfidence() + "\n\n");
        }
        
        if(this.urisNotFound.isEmpty()){
            result.append("All URIs in the correspondence are found in source or target.");
        } else {
            result.append("The following URIs are not found in source nor target: " + this.urisNotFound);
        }
        if(this.isSwitchOfSourceTargetBetter()){
            result.append("More left(entity one) in correspondence are found in target ontology. A switch of entity one and two in alignment makes sense!");
        }        

        return result.toString();
    }

    /**
     * Get the minimum confidence score of the alignment.
     * @return Minimum confidence as double.
     */
    public double getMinimumConfidence() {
        return this.minimumConfidence;
    }

    /**
     * Get the maximum confidence score of the alignment
     * @return Maximum confidence as double.
     */
    public double getMaximumConfidence() {
        return this.maximumConfidence;
    }

    /**
     * Checks whether the confidence scores of the given mapping are all equal to 1.0.
     * @return True if confidence scores = 1.0; else false.
     */
    public boolean isConfidenceScoresAreAlwaysOne(){
        if(minimumConfidence == 1.0 && maximumConfidence == 1.0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns true if each cell in the mapping uses the equivalence relation.
     * If multiple relations are used, false will be returned.
     * @return
     */
    public boolean isAlwaysEqualityRelation() {
        if(frequenciesOfRelations.size() == 1 && frequenciesOfRelations.containsKey(CorrespondenceRelation.EQUIVALENCE)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Returns a set of the different mapping relations (e.g. "=" or "&gt;") that are used in the mapping.
     * @return Mapping relations used as set.
     */
    public HashSet<CorrespondenceRelation> getRelationsUsed(){
        return new HashSet<CorrespondenceRelation>(frequenciesOfRelations.keySet());
    }

    /**
     * Returns a set of different mapping types (e.g. CLASS-CLASS) that are used in the mapping
     * @return Mapping types used as set.
     */
    public HashSet<String> getMappingTypesUsed(){
        return new HashSet<>(frequenciesOfMappingTypes.keySet());
    }

    /**
     * Returns true if the alignment is homogenous, i.e., whether only resources of the same type
     * are matched e.g. classes with classes and object properties with object properites.
     * @return
     */
    public boolean isHomogenousAlignment() {
        return this.isHomogenousAlingment;
    }

    /**
     * Returns true if the alignment is heterogenous, i.e., whether any resource types can be
     * matched with each other e.g. object properties with classes.
     * @return True if heterogenous else false.
     */
    public boolean isHeterogenousAlignment() {
        return !isHomogenousAlignment();
    }

    /**
     * Returns the frequency of different mapping types.
     * e.g. "class - class" → 55
     */
    public Map<String, Integer> getFrequenciesOfMappingTypes(){
        return frequenciesOfMappingTypes;
    }


    /**
     * Returns frequencies of relations in the given mapping.
     * Example: EQUIVALENCE → 40
     * @return Mapping of type {@code relation → frequency}.
     */
    public Map<CorrespondenceRelation, Integer> getFrequenciesOfRelations(){
        return this.frequenciesOfRelations;
    }


    /**
     * Print a textual report of the alignment to the console.
     */
    public void printReportForAlignmentToConsole() {
        System.out.println(getReportForAlignment());
    }


    /**
     * Returns the size of the mapping.
     * @return Size of the mapping as integer.
     */
    public int getNumberOfCorrespondences(){
        return executionResult.getSystemAlignment().size();
    }

    /**
     * Print a textual report using the logger.
     */
    public void logReportForAlignmentToConsole(){
        LOGGER.info("\n" + getReportForAlignment());
    }

    /**
     * Returns the number of URIs in correct position.
     * This means entity one in correspondence is found in source ontology
     * and entity two is found in target ontology.
     * @return number of URIs in correct position
     */
    public int getUrisCorrectPosition() {
        return urisCorrectPosition;
    }

    /**
     * Returns the number of URIs NOT in correct position.
     * This means entity one in correspondence is found in target ontology
     * and entity two is found in source ontology.
     * @return number of URIs NOT in correct position
     */
    public int getUrisIncorrectPosition() {
        return urisIncorrectPosition;
    }
    
    /**
     * Tests if a switch of source and target URIs makes sense 
     * e.g. more first entities of correspondnce are found in target ontology and not source ontology.
     * @return true if a switch of source and target URIs makes sense 
     */
    public boolean isSwitchOfSourceTargetBetter() {
        return urisCorrectPosition < urisIncorrectPosition;
    }

    /**
     * Returns a list of URIs which are found not in source nor target ontology.
     * @return List of URIs which are found not in source nor target ontology
     */
    public List<String> getUrisNotFound() {
        return urisNotFound;
    }

    /**
     * Return the map of arity to corresponding counts.
     * @return map of arity to corresponding counts
     */
    public Map<Arity, Integer> getArityCounts() {
        return arityCounts;
    }
    
}
