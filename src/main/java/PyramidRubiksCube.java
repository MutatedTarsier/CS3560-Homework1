public class PyramidRubiksCube {
    private char[][][] pyramid;
    private final int rows;
    private static final char[] colors = {'r', 'g', 'b', 'y'};
    private static final int NUM_FACES = 4;

    PyramidRubiksCube() {
        this.rows = 3;
        this.pyramid = new char[4][rows][];

    }

    public void initializeFaces(){
        /********************************************************
            Method:
            First create a 2D face array
            Then fill the face array with rows of size 1, 3, 5
            Purpose:
            Initialize all the faces of the pyramid with color characters
         ********************************************************/
        for (int face_index = 0; face_index < NUM_FACES; face_index++) {
            char[][] face = new char[rows][]; // Create the 2D face array to be filled
            for (int row_index = 1; row_index <= this.rows; row_index++) {
                // Iterate through the amount of rows
                char[] new_row = new char[row_index*2 - 1]; // Create an empty row array to be filled with columns
                for (int col_index = 0; col_index < row_index*2 - 1; col_index++) {
                    // Fill the row with columns of size row*2 - 1, which will become sizes 1, 3, 5
                    new_row[col_index] = colors[face_index];
                }
                // Place the new row into the 2D face
                face[row_index - 1] = new_row;
            }
            // Place the fully filled face into the 3D array of faces
            this.pyramid[face_index] = face;
        }
    }


    public void initializeEdges(){
        /********************************************************
         Method:
         First create a 2D face array
         Then fill the face array with rows of size 1, 3, 5
         If the column is at an edge position, place the color
         Else place '0'
         Purpose:
         Initialize only the edges with color characters and the rest with padding
         ********************************************************/

        for (int face_index = 0; face_index < NUM_FACES; face_index++) {
            char[][] face = new char[rows][]; // Create the 2D face array to be filled
            for (int row_index = 1; row_index <= this.rows; row_index++) {
                char[] new_row = new char[row_index*2 - 1]; // Create row to be filled
                for (int col_index = 0; col_index < row_index*2 - 1; col_index++) {
                    // Check if the column is in edge position, only for a pyramid of 3 rows for now
                    boolean secondRow_edges = row_index == 2 && (col_index == 0 || col_index == 2);
                    boolean thirdRow_edges = row_index == 3 && (col_index == 2);
                    if (secondRow_edges || thirdRow_edges) {
                        new_row[col_index] = colors[face_index]; // Place color character if at edge position
                    } else {
                        new_row[col_index] = '0'; // Place '0' if not at edge
                    }
                }
                face[row_index - 1] = new_row; // Place row into face
            }
            this.pyramid[face_index] = face; // Place face into all faces
        }
    }

    public boolean validateCube(){
        // Check that there are 9 tiles for each side
        for (char[][] face : this.pyramid) {
            // Loop through all faces
            int tile_sum = 0; // Sum of tiles for current face
            for (char[] row : face) {
                // Loop through all rows
                for (char col : row) {
                    // Loop through all columns and count
                    tile_sum += 1;
                }
            }
            if (tile_sum != 9) return false; // If tile_sum is not 9, cube is not valid
        }

        // Check that every side has a color
        for (int f = 0; f < this.pyramid.length; f++) {
            char[][] face = this.pyramid[f];
            // Loop through faces
            for (char[] row : face) {
                // Loop through rows
                for (char col : row) {
                    // Loop through columns
                    if (col != colors[f]) return false;
                }
            }
        }

        return true;
    }

    public char[][][] getPyramid() {
        /********************************************************
         Purpose:
         Getter for pyramid
         ********************************************************/
        return pyramid;
    }


}
