class Matrix {
    private int rows;
    private int columns;
    private int[][] elements;

    // Constructor
    public Matrix(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.elements = new int[rows][columns];
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }

    public void setElement(int i, int j, int value) {
        this.elements[i][j] = value;
    }

    public Matrix add(Matrix other) {
        if (this.rows != other.rows || this.columns != other.columns) {
            System.out.println("Dimensiunile matricelor nu se potrivesc");
            return null;
        }

        Matrix result = new Matrix(this.rows, this.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                result.elements[i][j] = this.elements[i][j] + other.elements[i][j];
            }
        }

        return result;
    }
    public Matrix multiply(Matrix other) {
        if (this.columns != other.rows) {
            System.out.println("Numărul de coloane al primei matrice trebuie să fie egal cu numărul de rânduri al celei de-a doua matrice");
            return null;
        }

        Matrix result = new Matrix(this.rows, other.columns);
        for (int i = 0; i < result.rows; i++) {
            for (int j = 0; j < result.columns; j++) {
                int sum = 0;
                for (int k = 0; k < this.columns; k++) {
                    sum += this.elements[i][k] * other.elements[k][j];
                }
                result.elements[i][j] = sum;
            }
        }

        return result;
    }
}


