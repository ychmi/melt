package de.uni_mannheim.informatik.dws.ontmatching.matchingeval.tracks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Developer note:
 * - This test requires a working internet connection.
 * - The SEALS servers must be online.
 * - While it might be desirable to test all tracks, note thait n the testing step of the continuous integration pipeline, all test cases
 * are re-downloaded which significantly slows down the build process.
 */
class TrackRepositoryTest {

    @Test
    public void testTracks(){
        // tests downloading process and implementation
        assertTrue(TrackRepository.Anatomy.Default.getTestCases().size() > 0);
    }

}