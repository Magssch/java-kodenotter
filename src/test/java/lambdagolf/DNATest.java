package lambdagolf;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

public class DNATest {

    DNA dna;

    @Before
    public void init() {
        dna = new DNA();
    }

    @Test
    public void sanityCheck() {
        assertEquals("DNA should be initialized with zero length", 0, dna.toString().trim().length());
    }

    @Test
    public void testGetComplementaryStrand() {
        dna.addGene("TTAAGCAT");
        assertEquals("DNA strand should be printed with complementary base pair nucleobases (e.g. A -> T etc.)",
                    "AATTCGTA",
                    dna.getComplementaryStrand()
                    );
    }

    @Test
    public void testAddGenes() {
        dna.addGene("GATTACA");
        assertEquals("DNA should be displayed with both strands when added",
                    "GATTACA\nCTAATGT",
                    dna.toString()
                    );
        dna.addGene("CATGAT");
        assertEquals("Genes should be concatenated when printed",
                     "GATTACACATGAT\nCTAATGTGTACTA",
                     dna.toString()
                     );
    }

    @Test
    public void testAddInvalidGene() {
        try {
            dna.addGene("GATQTEACKA");
            fail("Invalid DNA strands should not be able to be added");
        } catch(IllegalArgumentException e) {
            ;
        }
    }

    @Test
    public void testReorder() {
        dna.addGene("GATTACA");
        dna.addGene("GCCA");
        dna.addGene("TGAAGC");
        dna.addGene("GGAA");
        dna.reorder((a, b) -> {
            if (a.contains("TT")) return 1;
            if (b.contains("TT")) return -1;
            if (a.contains("GG")) return -1;
            if (b.contains("GG")) return 1;
            return a.compareTo(b);
        });
        assertEquals("DNA should be able to be reordered by a custom sorting function",
                     "GGAAGCCATGAAGCGATTACA\nCCTTCGGTACTTCGCTAATGT",
                     dna.toString());
    }

    @Test
    public void testFilterGenes() {
        dna.addGene("GATTACA");
        dna.addGene("GCCA");
        dna.addGene("TGAAGC");
        dna.addGene("GGAA");
        assertEquals("DNA should be able to be filtered",
                     "GGAA",
                     dna.getAllMatchingGenes(gene -> gene.contains("GG")).get(0)
                     );
    }

    @Test
    public void testContainsCodon() {
        dna.addGene("GATTACA");
        dna.addGene("TTGGAACC");
        dna.addGene("GACGAT");
        dna.addGene("TGAACA");
        assertTrue("GAC should be identified as a present codon", dna.containsCodon("GAC"));
        assertTrue("ACA should be identified as a present codon", dna.containsCodon("ACA"));
        try {
            dna.containsCodon("AC");
            fail("Codon should be required to be three in lengthm, or throw an IllegalArgumentException");
        } catch(IllegalArgumentException e) {
            ;
        }
    }

    @Test
    public void testTranscribeToRNA() {
        dna.addGene("GATTACA");
        dna.addGene("TTGGAACC");
        dna.addGene("GACGAT");
        dna.addGene("TGAACA");
        assertEquals("DNA is not correctly transcribed to RNA", "CUAAUGUAACCUUGGCUGCUAACUUGU", dna.transcribeToRNA());
    }

    @Test
    public void testGetComplementErrorHandling() {
        try {
            dna.getComplement('K');
            fail("getComplement should throw an IllegalArgumentException when given an invalid character");
        } catch(IllegalArgumentException e) {
            ;
        }
    }


}
