package com.company;

import java.util.*;

/**
 * Created by Anders on 02-Oct-17.
 */
public class Game
{
    List<Queue<Duck>> listOfQueues;


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

        ArrayList<Queue<Duck>> l1 = new ArrayList<>();
        ArrayList<Queue<Duck>> l2 = new ArrayList<>();

        int size = oldList.size();

        for(int i = 0; i < size-1; i++)
        {
            Queue<Duck> queue = new LinkedList<>();
            l1.add(queue);
        }
        for (int i = 0; i < size-1; i++)
        {
            Queue<Duck> queue2 = new LinkedList<>();
            l2.add(queue2);
        }

        while(!(l1.isEmpty()))
        {
            Random r1 = new Random();
            Random r2 = new Random();

            int ran1 = r1.nextInt(l1.size());
            int ran2 = r2.nextInt(oldList.size());

            Duck tempDuck;
            tempDuck = oldList.get(ran2).poll();

            l1.get(ran1).add(tempDuck);
            l2.get(ran1).add(tempDuck);

            if(l1.get(ran1).size() == size-1)
            {
                l1.remove(ran1);
            }
        }

        return runGame(l2);
    }

    public Duck getWinner()
    {
        List<Queue<Duck>> winnerList = runGame(listOfQueues);

        return winnerList.get(0).poll();
    }

}
