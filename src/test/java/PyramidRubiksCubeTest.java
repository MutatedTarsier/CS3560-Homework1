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
        pyramidRubiksCube.initializeFaces();
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
    void testInitializeEdges() {
        pyramidRubiksCube.initializeEdges();
        char[][][] pyramid = pyramidRubiksCube.getPyramid();
        char[][][] expected = new char[][][]{
                new char[][] {
                        new char[] {'0'},
                        new char[] {'r','0','r'},
                        new char[] {'0','0','r','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'g','0','g'},
                        new char[] {'0','0','g','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'b','0','b'},
                        new char[] {'0','0','b','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'y','0','y'},
                        new char[] {'0','0','y','0','0'},
                }
        };
        assertArrayEquals(expected, pyramid);
    }

    @Test
    void testValidateCubeFaces() {
        pyramidRubiksCube.initializeFaces();
        assertTrue(pyramidRubiksCube.validateCube());
    }

    @Test
    void testValidateCubeEdges() {
        pyramidRubiksCube.initializeEdges();
        assertFalse(pyramidRubiksCube.validateCube());
    }

    @Test
    void testInitializeOverrideFaces(){
        pyramidRubiksCube.initializeFaces();
        pyramidRubiksCube.initializeEdges();
        char[][][] pyramid = pyramidRubiksCube.getPyramid();
        char[][][] expected = new char[][][]{
                new char[][] {
                        new char[] {'0'},
                        new char[] {'r','0','r'},
                        new char[] {'0','0','r','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'g','0','g'},
                        new char[] {'0','0','g','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'b','0','b'},
                        new char[] {'0','0','b','0','0'},
                },
                new char[][] {
                        new char[] {'0'},
                        new char[] {'y','0','y'},
                        new char[] {'0','0','y','0','0'},
                }
        };
        assertArrayEquals(expected, pyramid);
    }

    @Test
    void testInitializeOverrideEdges(){
        pyramidRubiksCube.initializeEdges();
        pyramidRubiksCube.initializeFaces();
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
}