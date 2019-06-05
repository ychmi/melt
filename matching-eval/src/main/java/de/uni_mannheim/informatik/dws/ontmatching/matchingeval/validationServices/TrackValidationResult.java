package de.uni_mannheim.informatik.dws.ontmatching.matchingeval.validationServices;

import de.uni_mannheim.informatik.dws.ontmatching.matchingeval.tracks.LocalTrack;
import de.uni_mannheim.informatik.dws.ontmatching.matchingeval.tracks.TestCase;

import java.io.File;
import java.util.HashMap;

/**
 * Result object of the {@link TrackValidationService} process.
 *
 * @author Jan Portisch
 */
public class TrackValidationResult {

    /**
     * Constructor
     */
    public TrackValidationResult(){
        this.individualTrackValidationResults = new HashMap<>();
    }

    /**
     * The individual validation results per test case.
     */
    HashMap<TestCase, TestCaseValidationResult> individualTrackValidationResults;

    /**
     * Indicates whether the track is free of errors.
     * @return True if error free, else false.
     */
    public boolean isOK(){
        for(HashMap.Entry<TestCase, TestCaseValidationResult> entry: individualTrackValidationResults.entrySet()){
            if(!entry.getValue().isOK()){
                return false;
            }
        }
        return true;
    }


    @Override
    public String toString(){
        String result = "";
        for (HashMap.Entry<TestCase, TestCaseValidationResult> entry : individualTrackValidationResults.entrySet()){
            result = result + entry.toString() + "\n\n\n";
        }
        return result;
    }

    //---------------------------------------------------------------------------------------------
    // Getter
    //---------------------------------------------------------------------------------------------

    public HashMap<TestCase, TestCaseValidationResult> getIndividualTrackValidationResults() {
        return individualTrackValidationResults;
    }

    public static void main(String[] args) {
        LocalTrack localTrack = new LocalTrack("sap_fsdp", "0.1",new File("C:\\Users\\D060249\\OneDrive - SAP SE\\Documents\\PhD\\SAP_Mappings\\track4semantics\\2019-05-29"));
        System.out.println(TrackValidationService.analzye(localTrack));
    }

}

