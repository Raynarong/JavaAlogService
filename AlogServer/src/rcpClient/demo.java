package rcpClient;

import com.google.gson.*;
import java.util.*;

public class demo  {
  
    
    public double[] apply(String inpt){
        Data ind = new Gson().fromJson(inpt, Data.class);
        double[] output = new double[ind.data.size()];
       
        for(int i=0;i<ind.data.size();i++){
            if(ind.squared)
                output[i] = squareEuclid(ind.data.get(i));
            else
                output[i] = euclid(ind.data.get(i));
        }
        return output;
    }
    
    public double euclid(double[][] inpt){
        return Math.sqrt(squareEuclid(inpt));
    }
    
    public double squareEuclid(double[][] inpt){
        double output = 0;
        
        for(int i=0;i<inpt[0].length;i++){
            output += Math.pow(inpt[1][i]-inpt[0][i],2);
        }
        return output;
    }
    
    private static class Data{
        ArrayList<double[][]> data;
        Boolean squared = false;
        
        private String datos(double[][] values){
            StringBuilder s = new StringBuilder();
            s.append("[ ");
            
            for (int i = 0; i < values.length; ++i){
                if(i > 0)
                    s.append(",");
                    
                s.append('[');
                for (int j = 0; j < values[i].length; ++j){
                    if (j > 0)
                        s.append(",");
                        
                    s.append(values[i][j]);
                }
                s.append(']');
            }
            
            s.append(" ]");
            return s.toString();
        }
        
        @Override
        public String toString(){
            StringBuilder s = new StringBuilder();
            s.append("{data:[ ");
            for(int i=0;i<data.size();i++){
                if(i>0)
                    s.append(" , ");
                s.append(datos(data.get(i)));
            }
            s.append(" ] }");
            return s.toString();
        }
    }
    public static void main(String args[]){
    	demo de=new demo();
    	String a="{data:[[[1,2,3],[2,3,4]],[[1,2,3],[2,3,4]]],squared:true}";
    	double[] dd=de.apply(a);
    	System.out.println(dd);
    }
}
				
