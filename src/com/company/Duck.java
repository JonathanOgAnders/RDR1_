package com.company;

/**
 * Created by Anders on 02-Oct-17.
 */
public class Duck
{
    private int nr;

    public Duck(int nr)
    {
        this.nr = nr;
    }

    public int getNr()
    {
        return nr;
    }

    public void setNr(int nr)
    {
        this.nr = nr;
    }

    public String toString()
    {
        return "Jeg er and nr: " + nr + ". Jeg vandt. Juhu";
    }
}
