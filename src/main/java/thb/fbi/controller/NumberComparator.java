package thb.fbi.controller;

import java.util.Comparator;

/**
 * class for comparing strings made out of numbers
 * used for address in memory table
 */
public class NumberComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1 == null && o2 == null) return 0;
        if (o1 == null) return -1;
        if (o2 == null) return 1;

        
        Integer i1=null;
        Integer i2=null;
        // handling hex values
        if(o1.contains("0x") && o2.contains("0x")) {
            String s1 = o1.substring(2);
            String s2 = o2.substring(2);
            i1 = Integer.parseInt(s1, 16);
            i2 = Integer.parseInt(s2, 16);
        } else {
            try{ i1=Integer.valueOf(o1); } catch(NumberFormatException ignored){}
            try{ i2=Integer.valueOf(o2); } catch(NumberFormatException ignored){}
        }

        if(i1==null && i2==null) return o1.compareTo(o2);
        if(i1==null) return -1;
        if(i2==null) return 1;

        return i1-i2;
    }
    
}
