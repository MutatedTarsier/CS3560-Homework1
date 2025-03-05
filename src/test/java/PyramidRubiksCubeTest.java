import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PyramidRubiksCubeTest {
    PyramidRubiksCube pyramidRubiksCube;
    @BeforeEach
    void setUp() {
        pyramidRubiksCube = new PyramidRubiksCube();
    }

    @Test
    void testInitializeFaces() {

        char[][][] pyramid = pyramidRubiksCube.getPyramid();
        char[][][] expected = new char[][][]{
                new char[][] {
                        new char[] {'r'},
                        new char[] {'r','r','r'},
                        new char[] {'r','r','r','r','r'},
                },
                new char[][] {
                        new char[] {'g'},
                        new char[] {'g','g','g'},
                        new char[] {'g','g','g','g','g'},
                },
                new char[][] {
                        new char[] {'b'},
                        new char[] {'b','b','b'},
                        new char[] {'b','b','b','b','b'},
                },
                new char[][] {
                        new char[] {'y'},
                        new char[] {'y','y','y'},
                        new char[] {'y','y','y','y','y'},
                }
        };
        assertArrayEquals(expected, pyramid);
    }

       @Test
    void testValidateCubeFaces() {
        assertTrue(pyramidRubiksCube.validateCube());
    }

    @Test
    void testGetEdges() {
        char[][] expected = new char[][] {
                new char[] {'r', 'b'},
                new char[] {'r', 'y'},
                new char[] {'g', 'r'},
                new char[] {'g', 'y'},
                new char[] {'b', 'g'},
                new char[] {'b', 'y'}
        };
        assertArrayEquals(expected, pyramidRubiksCube.getEdges());

    }


}