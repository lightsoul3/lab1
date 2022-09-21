package lab0;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static lab0.Variant11.*;
import static org.testng.Assert.assertEquals;

import lab0.Variant11;
import lab0.Variant11.CARDINAL_DIRECTIONS;

public class Variant11Test {
    //Variant11 ob11 = new Variant11();

    //////////// Int Task ////////////////
    @Test(dataProvider = "integerProvider1")
    public void testIntTask1(int p1, int p3) {
        assertEquals(intTaskSum(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider1() {
        return new Object[][]{{929, 20}, {-673, -16}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntTest1() {
        intTaskSum(99);
    }


    ////
    @Test(dataProvider = "integerProvider2")
    public void testIntTask2(int p1, int p3) {
        assertEquals(intTaskProd(p1), p3);
    }

    @DataProvider
    public Object[][] integerProvider2() {
        return new Object[][]{{555, 125}, {-811, -8}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void negativeIntTest2() {
        intTaskProd(-11);
    }


    //////////// Boolean Task ////////////////
    @Test(dataProvider = "booleanProvider")
    public void testBooleanTask(int p1, int p2, boolean p3) {
        assertEquals(booleanTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] booleanProvider() {
        return new Object[][]{{28, 28, true}, {0, 1, false}};
    }


    //////////// If Task ////////////////
    @Test(dataProvider = "ifProvider")
    public void testIfTask(int p1, int p2,  int[] p3) {
        assertEquals(ifTask(p1, p2), p3);
    }

    @DataProvider
    public Object[][] ifProvider() {
        int[] res1 = {6, 6}, res2 = {90, 90}, res3 = {0, 0};
        return new Object[][]{{5, 6, res1}, {90, 24, res2}, {-1, -1, res3}};
    }


    //////////// Case Task ////////////////
    @Test(dataProvider = "caseProvider")
    public void testCaseTask(CARDINAL_DIRECTIONS S, int p1, int p2, CARDINAL_DIRECTIONS res) {
        assertEquals(caseTask(S, p1, p2), res);
    }

    @DataProvider
    public Object[][] caseProvider() {
        return new Object[][]{{CARDINAL_DIRECTIONS.WEST, -1, 2, CARDINAL_DIRECTIONS.SOUTH},
                {CARDINAL_DIRECTIONS.EAST, 2, 2, CARDINAL_DIRECTIONS.EAST}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testCaseErrorTask() {
        caseTask(CARDINAL_DIRECTIONS.EAST, -5, 0);
    }


    //////////// For Task ////////////////
    @Test(dataProvider = "forProvider")
    public void forTest(int p1, int p2) {
        assertEquals(forTask(p1), p2);
    }

    @DataProvider
    public Object[][] forProvider() {
        return new Object[][]{{3, 86}, {11, 3410}};
    }


    @Test(expectedExceptions = AssertionError.class)
    public void testForErrorTask() {
        forTask(-3);
    }


    //////////// While Task ////////////////
    @Test(dataProvider = "whileProvider")
    public void testWhileTask(int p1, int[] p2) {
        assertEquals(whileTask(p1), p2);
    }


    @DataProvider
    public Object[][] whileProvider() {
        int[] res4 = {3, 6}, res5 = {5, 15};
        return new Object[][]{{6, res4}, {11, res5}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testWhileErrorTask() {
        whileTask(1);
    }


    //////////// Array Task ////////////////

    @Test(dataProvider = "arrayProvider")
    public void testArrayTask(int[] a, int p2, int[] b) {
        assertEquals(arrayTask( a, p2), b);
    }


    @DataProvider
    public Object[][] arrayProvider() {
        int[] arrayCheck = {1, 2, 3, 4, 5, 6, 7};
        int[] arrayRes = {3, 5, 7};
        return new Object[][]{{arrayCheck, 2, arrayRes}};
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testArrayErrorTask1() {
        int[] arrayCheck = {1, 2, 3, 4, 5, 6, 7};
        arrayTask(arrayCheck, -3);
    }

    @Test(expectedExceptions = AssertionError.class)
    public void testArrayErrorTask2() {
        int[] arrayCheck = {1, 2, 3, 4, 5, 6, 7};
        arrayTask(arrayCheck, 8);
    }



    //////////// Matrix Task ////////////////
    @Test(dataProvider = "matrixProvider")
    public void testMatrixTask(int[][] a, int[][] b) {
        assertEquals(matrixTask(a), b);
    }

    @DataProvider
    public Object[][] matrixProvider() {
        int[][] arrayCheck1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] arrayRes1 = {{1, 2, 3}, {6, 5, 4}, {7, 8, 9}};
        return new Object[][]{{arrayCheck1, arrayRes1}};
    }
}


