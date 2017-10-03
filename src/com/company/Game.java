package com.company;

import java.util.*;

/**
 * Created by Anders on 02-Oct-17.
 */
public class Game
{
    private List<Queue<Duck>> listOfQueues;

    public Game()
    {
        listOfQueues = new ArrayList<>();
        int ducknr = 0;

        for (int i = 0; i < 10; i++)
        {
            Queue<Duck> queue = new LinkedList<>();
            for (int j = 0; j < 10; j++)
            {
                ducknr++;
                queue.add(new Duck(ducknr));
            }
            listOfQueues.add(queue);
        }
    }

    public List<Queue<Duck>> runGame(List<Queue<Duck>> oldList)
    {
        if(oldList.size() == 1)
        {
            return oldList;
        }

        ArrayList<Integer> intNew = new ArrayList<>();
        ArrayList<Integer> intOld = new ArrayList<>();

        ArrayList<Queue<Duck>> listOfQueues = new ArrayList<>();

        int size = oldList.size();

        for(int i = 0; i < size; i++)
        {
            intOld.add(i);
        }

        for (int i = 0; i < size-1; i++)
        {
            intNew.add(i);
            Queue<Duck> queue2 = new LinkedList<>();
            listOfQueues.add(queue2);
        }

        while(!(intNew.isEmpty()))
        {
            Collections.shuffle(intOld);
            Collections.shuffle(intNew);

            int ran1 = intNew.get(intNew.size()-1);
            int ran2 = intOld.get(intOld.size()-1);

//            System.out.println("ran1: " + ran1 + "\nran2: " + ran2);

            Duck tempDuck = oldList.get(ran2).poll();

            listOfQueues.get(ran1).add(tempDuck);

            if(listOfQueues.get(ran1).size() == size-1)
            {
                intNew.remove(intNew.indexOf(ran1));
            }
        }

        return runGame(listOfQueues);
    }

    public Duck getWinner()
    {
        List<Queue<Duck>> winnerList = runGame(listOfQueues);

        return winnerList.get(0).poll();
    }

}
