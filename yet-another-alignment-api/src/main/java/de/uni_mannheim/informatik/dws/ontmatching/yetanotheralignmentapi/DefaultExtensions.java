package de.uni_mannheim.informatik.dws.ontmatching.yetanotheralignmentapi;

/**
 * Default vocabulary as given by <a href="http://alignapi.gforge.inria.fr/labels.html">http://alignapi.gforge.inria.fr/labels.html</a>.
 *
 * @author Jan Portisch
 */
public class DefaultExtensions {

    /**
     * Standard API extensions by the AlignmentAPI.
     */
    public enum StandardApi {

        /**
         * STRING identifying the version of the alignment.
         */
        VERSION("http://exmo.inrialpes.fr/align/ext/1.0/#version "),

        /**
         * CLASSNAME of the generating matching method (or operation).
         */
        METHOD("http://exmo.inrialpes.fr/align/ext/1.0/#method "),

        /**
         * STRING identifying the method version.
         */
        METHOD_VERSION("http://exmo.inrialpes.fr/align/ext/1.0/#methodVersion"),

        /**
         * URI the alignment from which this one is issued, if applicable
         */
        DERIVED_FROM("http://exmo.inrialpes.fr/align/ext/1.0/#derivedFrom "),

        /**
         * STRING the parameters used with the generating method.
         */
        PARAMETERS("http://exmo.inrialpes.fr/align/ext/1.0/#parameters"),

        /**
         * STRING a certificate from an issuing source.
         */
        CERTIFICATE("http://exmo.inrialpes.fr/align/ext/1.0/#certificate"),

        /**
         * DURATION (default: INTEGER in milliseconds) of the matching process.
         */
        TIME("http://exmo.inrialpes.fr/align/ext/1.0/#time"),

        /**
         * STRING the validity range of the correspondence.
         */
        LIMITATIONS("http://exmo.inrialpes.fr/align/ext/1.0/#limitations"),

        /**
         * STRING the properties satisfied by an alignment or correspondences.
         */
        PROPERTIES("http://exmo.inrialpes.fr/align/ext/1.0/#properties"),

        /**
         * STRING a short descriptive name of the alignment.
         */
        PRETTY("http://exmo.inrialpes.fr/align/ext/1.0/#pretty"),

        /**
         * STRING a short descriptive name for the first aligned entity (in correspondences).
         */
        LABEL_1("http://exmo.inrialpes.fr/align/ext/1.0/#label1"),

        /**
         * STRING a short descriptive name for the second aligned entity (in correspondences).
         */
        LABEL_2("http://exmo.inrialpes.fr/align/ext/1.0/#label2"),

        /**
         * STRING identify the tools and versions who created the alignments (concatenated by ;).
         */
        PROVENANCE("http://exmo.inrialpes.fr/align/ext/1.0/#provenance");

        /**
         * The URI of the extension label.
         */
        private String uri;

        StandardApi(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * Linkkey Extensions
     */
    public enum Linkkey {

        /**
         * STRING describes the type of linkkey when extracted (weak/strong/plain).
         */
        TYPE("http://melinda.inrialpes.fr/ns/linkkey/type"),

        /**
         * PERCENTAGE of links in a sample, which are generated by the linkkey (relative recall).
         */
        RRECALL("http://melinda.inrialpes.fr/ns/linkkey/rrecall"),

        /**
         * PERCENTAGE of links generated by the linkkey, which are in a sample (relative precision).
         */
        RPRECISION("http://melinda.inrialpes.fr/ns/linkkey/rprecision"),

        /**
         * PERCENTAGE of one-to-one links generated by the linkkey on a particular dataset.
         */
        COVERAGE("http://melinda.inrialpes.fr/ns/linkkey/coverage"),

        /**
         * PERCENTAGE of instances which are linked by this linkkey on a particular dataset.
         */
        DISCRIMINABILITY("http://melinda.inrialpes.fr/ns/linkkey/discriminabilty");

        /**
         * The URI of the extension label.
         */
        private String uri;

        Linkkey(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * Dublin Core Extensions
     */
    public enum DublinCore {

        /**
         * STRING identifying an entity primarily responsible for making the alignment.
         */
        CREATOR("http://purl.org/dc/elements/1.1/creator"),

        /**
         * TIMESTAMP of an event in the lifecycle of the alignment.
         */
        DATE("http://purl.org/dc/elements/1.1/date"),

        /**
         * STRING describing the alignment.
         */
        DESCRIPTION("http://purl.org/dc/elements/1.1/description"),

        /**
         * sameAs http://knowledgeweb.semanticweb.org/heterogeneity/alignment#id.
         */
        IDENTIFIER("http://purl.org/dc/elements/1.1/identifier"),

        /**
         * STRING providing information about rights held in and over the alignment.
         */
        RIGHTS("http://purl.org/dc/elements/1.1/rights"),

        /**
         * sameAs http://exmo.inrialpes.fr/align/ext/1.0/#pretty.
         */
        TITLE("http://purl.org/dc/elements/1.1/title");

        /**
         * The URI of the extension label.
         */
        private String uri;

        DublinCore(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * OMWG Extensions
     */
    public enum OMWG {

        /**
         * STRING The purpose for which an alignment has been defined
         */
        PURPOSE("http://www.owmg.org/TR/d7/d7.2/purpose");

        /**
         * The URI of the extension label.
         */
        private String uri;

        OMWG(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }

    /**
     * Alignment server extensions.
     */
    public enum AlignmentServer {

        /**
         * STRING uniquely identifying the alignment.
         */
        ALID("http://exmo.inrialpes.fr/align/service#alid"),

        /**
         * TIMESTAMP of the last time the alignment was read
         */
        CACHED("http://exmo.inrialpes.fr/align/service#cached"),

        /**
         * TIMESTAMP of the time the alignment was stored in database.
         */
        STORED("http://exmo.inrialpes.fr/align/service#stored"),

        /**
         * URI of the first ontology (temporary store).
         */
        OURI1("http://exmo.inrialpes.fr/align/service#ouri1"),

        /**
         * URI of the second ontology (temporary store).
         */
        OURI2("http://exmo.inrialpes.fr/align/service#ouri2");

        /**
         * The URI of the extension label.
         */
        private String uri;

        AlignmentServer(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * Argumentation Extensions
     */
    public enum Argumentation {

        /**
         * STRING denoting an argument for the correspondence to be valid or invalid.
         */
        REASON("http://ac.liv.ac.uk/just#reason"),

        /**
         * STRING denoting the type of method used for supporting a correspondence (this is a value in value argumentation framework).
         */
        TYPE("http://ac.liv.ac.uk/just#type"),

        /**
         * BOOLEAN denoting if the argument is in favour or against
         */
        SUPPORT("http://ac.liv.ac.uk/just#support");

        /**
         * The URI of the extension label.
         */
        private String uri;

        Argumentation(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * Ontology Metadata Vocabulary being a metadata ontology introduces many different labels that can be used in
     * Alignment and correspondences but also defines it own sorts of objects that can be annotated.
     */
    public enum OmvMetadata {

        //-----------------------------------------------------------------------------------------
        // Basic Alignment Metadata
        //-----------------------------------------------------------------------------------------

        /**
         * Is the OMV type for all mapping objects, can be used as extensions for specifying a subclass of omv:Mapping.
         */
        MAPPING("http://omv.ontoware.org/2007/05/mappingomv#Mapping"),

        /**
         *  sameAs http://exmo.inrialpes.fr/align/ext/1.0/#parameters
         */
        HAS_PARAMETER("http://omv.ontoware.org/2007/05/mappingomv#hasParameter"),

        /**
         * sameAs http://purl.org/dc/elements/1.1/:creator
         */
        HAS_CREATOR("http://omv.ontoware.org/2007/05/mappingomv#hasCreator"),

        /**
         * sameAs http://exmo.inrialpes.fr/align/ext/1.0/#method
         */
        USED_METHOD("http://omv.ontoware.org/2007/05/mappingomv#usedMethod"),

        /**
         * STRING denoting [??]
         */
        VARIETY("http://omv.ontoware.org/2007/05/mappingomv#variety"),

        /**
         * sameAs http://knowledgeweb.semanticweb.org/heterogeneity/alignment#type
         */
        TYPE("http://omv.ontoware.org/2007/05/mappingomv#type"),

        /**
         * sameAs http://www.owmg.org/TR/d7/d7.2/purpose
         */
        PURPOSE("http://omv.ontoware.org/2007/05/mappingomv#purpose"),

        /**
         * sameAs http://knowledgeweb.semanticweb.org/heterogeneity/alignment#id
         */
        URI("http://omv.ontoware.org/2007/05/mappingomv#URI"),

        /**
         * sameAs http://exmo.inrialpes.fr/align/ext/1.0/#time
         */
        PROCESSING_TIME("http://omv.ontoware.org/2007/05/mappingomv#processingTime"),

        /**
         * STRING denoting [??]
         */
        VALUE("http://omv.ontoware.org/2007/05/mappingomv#value"),

        /**
         * sameAs http://purl.org/dc/elements/1.1/:language
         */
        NATURAL_LANGUAGE("http://omv.ontoware.org/2007/05/mappingomv#naturalLanguage"),

        /**
         * sameAs http://knowledgeweb.semanticweb.org/heterogeneity/alignment#level
         */
        LEVEL("http://omv.ontoware.org/2007/05/mappingomv#level"),

        /**
         * sameAs http://knowledgeweb.semanticweb.org/heterogeneity/alignment#uri1
         */
        SOURCE("http://omv.ontoware.org/2007/05/mappingomv#source"),

        /**
         * sameAs http://purl.org/dc/elements/1.1/:date
         */
        CREATION_DATE("http://omv.ontoware.org/2007/05/mappingomv#creationDate"),

        /**
         * sameAs http://exmo.inrialpes.fr/align/ext/1.0/#methodVersion
         */
        VERSION("http://omv.ontoware.org/2007/05/mappingomv#version"),


        //-----------------------------------------------------------------------------------------
        // Matching Method Metadata
        //-----------------------------------------------------------------------------------------

        /**
         * is the OMV class of mapping methods
         */
        MAPPING_METHOD("http://omv.ontoware.org/2007/05/mappingomv#MappingMethod"),

        /**
         * STRING denoting an atomic method
         */
        BASIC_METHOD("http://omv.ontoware.org/2007/05/mappingomv#BasicMethod"),

        /**
         * sameAs http://exmo.inrialpes.fr/align/ext/1.0/#method="manual"
         */
        MANUAL_METHOD("http://omv.ontoware.org/2007/05/mappingomv#ManualMethod"),

        /**
         * STRING denotting a method made by composing other methods
         */
        COMPOUND_METHOD("http://omv.ontoware.org/2007/05/mappingomv#CompoundMethod"),

        /**
         * STRING denoting a method obtained by parallel composition of other methods
         */
        PARALLEL("http://omv.ontoware.org/2007/05/mappingomv#Parallel"),

        /**
         * STRING denoting a method obtained by parallel composition of other methods
         */
        SEQUENCE("http://omv.ontoware.org/2007/05/mappingomv#Sequence"),

        /**
         * STRING denoting the parameters of the method
         */
        PARAMETER("http://omv.ontoware.org/2007/05/mappingomv#Parameter"),

        /**
         * #CompoundMethod linking a compound method to its components
         */
        COMPOSES_METHOD("http://omv.ontoware.org/2007/05/mappingomv#composesMethod"),

        /**
         * #Method denoting the aggregation of the result of several methods
         */
        AGGREGATES_METHOD("http://omv.ontoware.org/2007/05/mappingomv#aggregatesMethod"),

        /**
         * STRING denoting a method made by filtering the result of another
         */
        FILTER("http://omv.ontoware.org/2007/05/mappingomv#Filter"),

        /**
         * #Method links a filter to the method it filters
         */
        FILTERS_METHOD("http://omv.ontoware.org/2007/05/mappingomv#filtersMethod"),

        /**
         * STRING denoting the name of an algorithm implemented by a BasicMethod
         */
        ALGORITHM("http://omv.ontoware.org/2007/05/mappingomv#Algorithm"),


        //-----------------------------------------------------------------------------------------
        // Evidence metadata
        //-----------------------------------------------------------------------------------------

        /**
         * #Property linking to properties satisfied by the alignment
         */
        HAS_PROPERTY("http://omv.ontoware.org/2007/05/mappingomv#hasProperty"),

        /**
         * STRING denoting evidence in favour of the alignment properties
         */
        EVIDENCE("http://omv.ontoware.org/2007/05/mappingomv#Evidence"),

        /**
         * STRING denoting proofs of properties
         */
        PROOF("http://omv.ontoware.org/2007/05/mappingomv#Proof"),

        /**
         * STRING denoting properties that an alignment may satisfy
         */
        PROPERTY("http://omv.ontoware.org/2007/05/mappingomv#Property"),

        /**
         * #Evidence linking to the evidence for a property
         */
        HAS_EVIDENCE("http://omv.ontoware.org/2007/05/mappingomv#hasEvidence");

        /**
         * The URI of the extension label.
         */
        private String uri;

        OmvMetadata(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


    /**
     * Additional vocabulary introduced with the MELT framework.
     */
    public enum MeltExtensions {
        /**
         * The confidence by the annotator of the gold standard for a particular correspondence.
         * This is required because the confidence in the alignment/correspondence is ALWAYS set by the matcher (hence,
         * 0 in the case of false positives). In order to also track the annotators confidence, this extension can
         * be used.
         */
        GOLD_STANDARD_CONFIDENCE("http://melt.dws.uni-mannheim.de/vocabulary#gold-standard-confidence");

        /**
         * The URI of the extension label.
         */
        private String uri;

        MeltExtensions(String uri){
            this.uri = uri;
        }

        @Override
        public String toString(){
            return this.uri;
        }
    }


}
