package com.example.game;

import android.os.Bundle;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;


public class SudokuGame {

    private Player newPlayer;
    long startSudoku = System.nanoTime();
    HashMap<ArrayList<Integer>, Integer> sudoku;

    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle1 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle2 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle3 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle4 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle5 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle6 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle7 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle8 = new ArrayList<ArrayList<Integer>>();
    private ArrayList<ArrayList<Integer>> ThreeByThreeBundle9 = new ArrayList<ArrayList<Integer>>();


    public SudokuGame(Player player, HashMap<ArrayList<Integer>, Integer> sudoku){
        this.newPlayer = player;
        this.sudoku = sudoku;
    }

    public int endPoint(){
        int count = 0;
        for (Integer i : sudoku.values() ){
            if (i != 0){
                count +=1;
            }
        }
        return count;
    }



    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle1() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 1; i < 4; i++){
            for (int j = 1; j < 4; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle2() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 4; i < 7; i++){
            for (int j = 1; j < 4; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle3() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 7; i < 10; i++){
            for (int j = 1; j < 4; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle4() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 4; i < 7; i++){
            for (int j = 1; j < 4; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle5() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 4; i < 7; i++){
            for (int j = 4; j < 7; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle6() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 4; i < 7; i++){
            for (int j = 7; j < 10; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle7() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 7; i < 10; i++){
            for (int j = 1; j < 4; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle8() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 7; i < 10; i++){
            for (int j = 4; j < 7; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    public ArrayList<ArrayList<Integer>> getThreeByThreeBundle9() {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        for (int i = 7; i < 10; i++){
            for (int j = 7; j < 10; j++){
                ArrayList<Integer> a = new ArrayList<Integer>();
                a.add(i);
                a.add(j);
                ans.add(a);
            }
        }
        return ans;
    }

    ArrayList<ArrayList<ArrayList<Integer>>> sudokuDimension= new ArrayList<ArrayList<ArrayList<Integer>>>(
            Arrays.asList(ThreeByThreeBundle1,ThreeByThreeBundle2,ThreeByThreeBundle3,
                    ThreeByThreeBundle4,ThreeByThreeBundle5,ThreeByThreeBundle6,
                    ThreeByThreeBundle7,ThreeByThreeBundle8,ThreeByThreeBundle9)
    );

    public ArrayList<ArrayList<ArrayList<Integer>>> getSudokuDimension() {
        ArrayList<ArrayList<ArrayList<Integer>>> ans = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ans.add(getThreeByThreeBundle1());
        ans.add(getThreeByThreeBundle2());
        ans.add(getThreeByThreeBundle3());
        ans.add(getThreeByThreeBundle4());
        ans.add(getThreeByThreeBundle5());
        ans.add(getThreeByThreeBundle6());
        ans.add(getThreeByThreeBundle7());
        ans.add(getThreeByThreeBundle8());
        ans.add(getThreeByThreeBundle9());
        return ans;
    }



    public boolean checkThreeByThree(int Input, int x, int y, HashMap<ArrayList<Integer>,Integer> s){
        ArrayList<Integer> key = new ArrayList<Integer>();
        key.add(x);
        key.add(y);
        ArrayList<ArrayList<ArrayList<Integer>>> dim = new ArrayList<ArrayList<ArrayList<Integer>>>();
        dim = getSudokuDimension();

        for (ArrayList<ArrayList<Integer>> bundle:dim){
            for (ArrayList<Integer> position: bundle){
                if (position.equals(key)){
                    for (ArrayList<Integer> pos:bundle){
                        if (Input == (s.get(pos))){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    public boolean checkCol(int Input, int x, HashMap<ArrayList<Integer>,Integer> s){

        for (ArrayList<Integer> position:s.keySet()){
            if (position.get(0).equals(x)){
                if (Input == (s.get(position))){
                    return false;
                }
            }
        }
        return false;
    }

    public boolean checkRow(int Input, int y, HashMap<ArrayList<Integer>,Integer> s){
        for (ArrayList<Integer> position:s.keySet()){
            if (position.get(1).equals(y)){
                if (Input == (s.get(position))){
                    return false;
                }
            }
        }
        return false;
    }

    public boolean insert(int Input, int x, int y, HashMap<ArrayList<Integer>,Integer> s){
        ArrayList<Integer> key = new ArrayList<Integer>();
        key.add(x);
        key.add(y);
        boolean rowCorrect = checkRow(Input,y,s);
        boolean colCorrect = checkCol(Input,x,s);
        boolean tbtCorrect = checkThreeByThree(Input,x,y,s);

        if (rowCorrect && colCorrect && tbtCorrect){
            s.put(key, Input);
            return true;
        }else{
            return false;
        }

    }











}






