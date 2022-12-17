import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(BattleField.fieldValidator(new int[][]{
                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 1},
                {0, 1, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 0},
                {1, 1, 1, 0, 1, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 1, 1},
                {0, 0, 0, 1, 0, 0, 0, 0, 0, 0}}));

    }

    public class BattleField {

        public static boolean fieldValidator(int[][] field) {
            int battleship = 0;
            int cruisers = 0;
            int destroyers = 0;
            int submarines = 0;
            int sum = 0;
            for (int[] ints : field) {
                System.out.println(Arrays.toString(ints));
            }

            System.out.println();

            for (int i = 1; i < field.length - 1; i++) {
                for (int j = 1; j < 9; j++) {
                    if (((field[i][j] == 1) && (field[i + 1][j]) == 1 && (field[i][j + 1] == 1) && (field[i + 1][j + 1] == 1))
                            || ((field[i][j] == 1) && (field[i + 1][j]) == 1 && (field[i + 1][j + 1] == 1))
                            || ((field[i][j] == 1) && (field[i + 1][j]) == 1 && (field[i + 1][j - 1] == 1))
                            || ((field[i][j] == 1) && (field[i][j + 1]) == 1 && (field[i + 1][j + 1] == 1))
                            || ((field[i][j] == 1) && (field[i][j + 1]) == 1 && (field[i + 1][j] == 1))
                            || ((field[i][j] == 1) && (field[i + 1][j + 1] == 1))
                            || ((field[i][j] == 1) && (field[i + 1][j - 1] == 1))) {
                        return false;
                    }
                }
            }

            for (int[] ints : field) {
                for (int anInt : ints) {
                    if (anInt == 1) {
                        sum++;
                        if (sum > 4) {
                            return false;
                        }
                    } else {
                        if (sum == 2) {
                            destroyers++;
                        } else if (sum == 3) {
                            cruisers++;
                        } else if (sum == 4) {
                            battleship++;
                        }
                        sum = 0;
                    }
                }
                if (sum == 2) {
                    destroyers++;
                } else if (sum == 3) {
                    cruisers++;
                } else if (sum == 4) {
                    battleship++;
                }
                sum = 0;
            }

            for (int i = 0; i < field.length - 4; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((field[i][j] == 1) && (field[i + 1][j] == 1) && (field[i + 2][j] == 1)
                            && (field[i + 3][j] == 1) && (field[i + 4][j] == 1)) {
                        return false;
                    }
                }
            }

            for (int i = 0; i < field.length - 3; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((field[i][j] == 1) && (field[i + 1][j] == 1) && (field[i + 2][j] == 1)
                            && (field[i + 3][j] == 1)) {
                        battleship++;
                    }
                }
            }

            for (int i = 0; i < field.length - 2; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i > 0 && i < field.length - 3) {
                        if (((field[i][j] == 1) && (field[i + 1][j] == 1) && (field[i + 2][j] == 1)
                                && (field[i + 3][j] == 0)) && (field[i - 1][j] == 0)) {
                            cruisers++;
                        }
                    } else if (i == 0) {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 1) && (field[i + 2][j] == 1)
                                && (field[i + 3][j] == 0)) {
                            cruisers++;
                        }
                    } else {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 1) && (field[i + 2][j] == 1)
                                && (field[i - 1][j] == 0)) {
                            cruisers++;
                        }
                    }
                }
            }

            for (int i = 0; i < field.length - 1; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i > 0 && i < 8) {
                        if (((field[i][j] == 1) && (field[i + 1][j] == 1)
                                && (field[i + 2][j] == 0)) && (field[i - 1][j] == 0)) {
                            destroyers++;
                        }
                    } else if (i == 0) {
                        if (((field[i][j] == 1) && (field[i + 1][j] == 1)
                                && (field[i + 2][j] == 0))) {
                            destroyers++;
                        }
                    } else {
                        if (((field[i][j] == 1) && (field[i + 1][j] == 1)
                                && (field[i - 1][j] == 0))) {
                            destroyers++;
                        }
                    }
                }
            }

            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    if ((i > 0) && (j > 0) && (i < 9) && (j < 9)) {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 0) && (field[i][j + 1] == 0)
                                && (field[i - 1][j]) == 0 && (field[i][j - 1] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 9) && (j < 9) && (j > 0)) {
                        if ((field[i][j] == 1) && (field[i - 1][j] == 0) && (field[i][j + 1] == 0) && (field[i][j - 1] == 0)) {
                            submarines++;
                        }
                    } else if ((j == 9) && (i < 9) && (i > 0)) {
                        if ((field[i][j] == 1) && (field[i][j - 1] == 0) && (field[i + 1][j] == 0) && (field[i - 1][j] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 0) && (j < 9) && (j > 0)) {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 0) && (field[i][j + 1] == 0) && (field[i][j - 1] == 0)) {
                            submarines++;
                        }
                    } else if ((j == 0) && (i < 9) && (i > 0)) {
                        if ((field[i][j] == 1) && (field[i][j + 1] == 0) && (field[i + 1][j] == 0) && (field[i - 1][j] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 0) && (j == 9)) {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 0) && (field[i][j - 1] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 9) && (j == 0)) {
                        if ((field[i][j] == 1) && (field[i - 1][j] == 0) && (field[i][j + 1] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 0) && (j == 0)) {
                        if ((field[i][j] == 1) && (field[i + 1][j] == 0) && (field[i][j + 1] == 0)) {
                            submarines++;
                        }
                    } else if ((i == 9) && (j == 9)) {
                        if ((field[i][j] == 1) && (field[i - 1][j] == 0) && (field[i][j - 1] == 0)) {
                            submarines++;
                        }
                    }
                }
            }
            System.out.println(battleship + " " + cruisers + " " + destroyers + " " + submarines);
            return battleship == 1 && cruisers == 2 && destroyers == 3 && submarines == 4;
        }
    }
}