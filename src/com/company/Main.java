package com.company;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        int[] check = new int[15];
        ArrayList<Integer> cards = new ArrayList<>();
        int cardsTotal = 0;

        for(int i=6;i<=14;i++){
            check[i]=4;
        }

        // 11 - valet, 12 - dama, 13 - korol, 14 - tuz

        ArrayDeque<Integer> firstPlayer = new ArrayDeque<>();
        ArrayDeque<Integer> secondPlayer = new ArrayDeque<>();

        //Razdacha kart
        while (cardsTotal<36){
            int i;
            while(true){
                i = random.nextInt(9)+6;
                if(check[i]>0) {
                    firstPlayer.addFirst(i);
                    check[i]--;
                    cardsTotal++;
                    break;
                }
            }
            while(true){
                i = random.nextInt(9)+6;
                if(check[i]>0) {
                    secondPlayer.addFirst(i);
                    check[i]--;
                    cardsTotal++;
                    break;
                }
            }
        }

        System.out.println("Раздача карт....");
        System.out.println();

        int i = 0;
        //Sama igra
        while(true){

            if(firstPlayer.size()==0){
                System.out.println("Второй игрок выиграл!");
                break;
            }
            if(secondPlayer.size()==0){
                System.out.println("Первый игрок выиграл!");
                break;
            }

            if(firstPlayer.peekFirst()>secondPlayer.peekFirst()){
                if(i==0) {
                    System.out.println("У первого игрока "+firstPlayer.peekFirst()+" У второго игрока " +secondPlayer.peekFirst());
                    firstPlayer.addLast(firstPlayer.pollFirst());
                    firstPlayer.addLast(secondPlayer.pollFirst());
                    System.out.println("Первый забирает, всего карт у первого игрока " + firstPlayer.size()+" всего карт у второго игрока " + secondPlayer.size());
                    System.out.println();
                }
                if(i>0){
                    System.out.println("У первого игрока "+firstPlayer.peekFirst()+" У второго игрока - " +secondPlayer.peekFirst());
                    firstPlayer.addLast(firstPlayer.pollFirst());
                    for (int j=0;j<i;j++){
                        firstPlayer.addLast(cards.get(j));
                    }
                    i = 0;
                    cards.clear();
                    firstPlayer.addLast(secondPlayer.pollFirst());
                    System.out.println("Первый игрок забирает, всего карт у первого игрока " + firstPlayer.size()+" всего карт у второго игрока " + secondPlayer.size());
                    System.out.println();
                }
            }
            else if (firstPlayer.peekFirst()<secondPlayer.peekFirst()){
                if(i==0) {
                    System.out.println("У первого игрока "+firstPlayer.peekFirst()+" У второго игрока " +secondPlayer.peekFirst());
                    secondPlayer.addLast(secondPlayer.pollFirst());
                    secondPlayer.addLast(firstPlayer.pollFirst());
                    System.out.println("Второй игрок забирает, всего карт у первого игрока " + firstPlayer.size()+" всего карт у второго игрока " + secondPlayer.size());
                    System.out.println();
                }
                if(i>0){
                    System.out.println("У первого игрока "+firstPlayer.peekFirst()+" У второго игрока " +secondPlayer.peekFirst());
                    secondPlayer.addLast(secondPlayer.pollFirst());
                    for (int j=0;j<i;j++){
                        secondPlayer.addLast(cards.get(j));
                    }
                    i = 0;
                    cards.clear();
                    secondPlayer.addLast(firstPlayer.pollFirst());
                    System.out.println("Второй игрок забирает, всего карт у первого игрока " + firstPlayer.size()+" всего карт у второго игрока " + secondPlayer.size());
                    System.out.println();
                }
            }

            else if (firstPlayer.peekFirst()==secondPlayer.peekFirst()){
                if((firstPlayer.size()>2)&&(secondPlayer.size()>2)) {
                    System.out.println("У первого игрока " + firstPlayer.peekFirst() + " У второго игрока " + secondPlayer.peekFirst());
                    cards.add(firstPlayer.pollFirst());
                    cards.add(firstPlayer.pollFirst());
                    cards.add(secondPlayer.pollFirst());
                    cards.add(secondPlayer.pollFirst());
                    i = cards.size();
                    System.out.println("Карты равны ещё один раунд");
                    System.out.println();
                } else{
                    System.out.println("У первого игрока " + firstPlayer.peekFirst() + " У второго игрока " + secondPlayer.peekFirst());
                    cards.add(firstPlayer.pollFirst());
                    cards.add(secondPlayer.pollFirst());
                    i = cards.size();
                    System.out.println("Карты равны ещё один раунд");
                    System.out.println();
                }
            }
        }
        System.out.println();
    }

}