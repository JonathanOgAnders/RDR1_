package com.company;

public class Main
{
    public static void main(String[] args)
    {

        for (int i = 0; i < 200 ; i++)
        {
            Game game = new Game();
            System.out.println(game.getWinner());
        }
    }
}
