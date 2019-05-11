package eg.edu.alexu.csd.datastructure.linkedList.cs55_cs65;

public class PolynomialSolver implements IPolynomialSolver {
    DList yallaA = new DList();
    DList yallaB = new DList();
    DList yallaC = new DList();
    DList yallaR = new DList();
    int o;

    public void setPolynomial(char poly, int[][] terms) {
        int x = terms.length;
        this.o = x;
        int y = terms[0].length;
        for (int counter = 0; counter < x; counter++) {
            for (int i = 0; i < x - 1; i++) {
                if (terms[i][1] < terms[i + 1][1]) {
                    int temp1, temp2;
                    temp1 = terms[i][0];
                    temp2 = terms[i][1];
                    terms[i][0] = terms[i + 1][0];
                    terms[i][1] = terms[i + 1][1];
                    terms[i + 1][0] = temp1;
                    terms[i + 1][1] = temp2;
                }
            }
        }  // ordering array
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (poly == 'A')
                    yallaA.add(terms[i][j]);
                if (poly == 'B')
                    yallaB.add(terms[i][j]);
                if (poly == 'C')
                    yallaC.add(terms[i][j]);
                if (poly == 'R')
                    yallaR.add(terms[i][j]);
            }

        }
    }
    public int[][] add(char poly1, char poly2)
    {
        DList temp1 =new DList();
        DList temp2 =new DList();
        if(poly1=='A'&&poly2=='B')
        {
             temp1 =yallaA;
             temp2=yallaB;
        }
        else if(poly1=='A'&&poly2=='C')
        {
             temp1=yallaA;
             temp2=yallaC;
        }
        else if(poly1=='B'&& poly2=='C' )
        {
             temp1=yallaB;
             temp2=yallaC;
        }
        int SizeTemp1 =temp1.size() ;
        int SizeTemp2 = temp2.size();
        int size=(SizeTemp1/2)*(SizeTemp2/2);
        int [][] res=new int[size][2];
        int k=0,hamo=0;
            if (temp1.isEmpty()||temp2.isEmpty())
            {
                if (temp1.isEmpty())
                {
                    for (int i=1;i<SizeTemp2;i+=2)
                    {
                        res[k][0]=(int)temp2.get(i-1);
                        res[k][1]=(int)temp2.get(i);
                        k++;
                    }
                    return res;
                }
                else
                {
                    for (int i=1;i<SizeTemp1;i+=2)
                    {
                        res[k][0]=(int)temp2.get(i-1);
                        res[k][1]=(int)temp1.get(i);
                        k++;
                    }
                    return res;
                }
            }
            else if(temp1.isEmpty()&&temp2.isEmpty())
            {
                System.out.print("{"+0+","+0+"}");
                return res;
            }
            else {
                for (int i = 1; i < SizeTemp1; i += 2) {
                    for (int j = 1; j < SizeTemp2; j += 2) {
                        if ((int) temp1.get(i) == (int) temp2.get(j)) {
                            res[k][0] = (int) temp1.get(i-1) + (int) temp2.get(j-1);
                            res[k][1] = (int) temp1.get(i);
                            k++;
                            hamo=1;
                        }
                    }
                    if (hamo==0)
                    {
                        res[k][0]=(int)temp1.get(i-1);
                        res [k][1]=(int) temp1.get(i);
                        k++;
                    }
                    hamo=0;
                }
            }

        return res;
    }
    public int[][] subtract(char poly1, char poly2)
    {
        DList temp1 =new DList();
        DList temp2 =new DList();
        if(poly1=='A'&&poly2=='B')
        {
            temp1 =yallaA;
            temp2=yallaB;
        }
        else if(poly1=='A'&&poly2=='C')
        {
            temp1=yallaA;
            temp2=yallaC;
        }
        else if(poly1=='B'&& poly2=='C' )
        {
            temp1=yallaB;
            temp2=yallaC;
        }
        int SizeTemp1 =temp1.size() ;
        int SizeTemp2 = temp2.size();
        int size=(SizeTemp1/2)*(SizeTemp2/2);
        int [][] res=new int[size][2];
        int k=0,hamo=0;
        if (temp1.isEmpty()||temp2.isEmpty())
        {
            if (temp1.isEmpty())
            {
                for (int i=1;i<SizeTemp2;i+=2)
                {
                    res[k][0]=(int)temp2.get(i-1);
                    res[k][1]=(int)temp2.get(i);
                    k++;
                }
                return res;
            }
            else
            {
                for (int i=1;i<SizeTemp1;i+=2)
                {
                    res[k][0]=(int)temp2.get(i-1);
                    res[k][1]=(int)temp1.get(i);
                    k++;
                }
                return res;
            }
        }
        else if(temp1.isEmpty()&&temp2.isEmpty())
        {
            System.out.print("{"+0+","+0+"}");
            return res;
        }
        else {
            for (int i = 1; i < SizeTemp1; i += 2) {
                for (int j = 1; j < SizeTemp2; j += 2) {
                    if ((int) temp1.get(i) == (int) temp2.get(j)) {
                        res[k][0] = (int) temp1.get(i-1) - (int) temp2.get(j-1);
                        res[k][1] = (int) temp1.get(i);
                        k++;
                        hamo=1;
                    }
                }
                if (hamo==0)
                {
                    res[k][0]=(int)temp1.get(i-1);
                    res [k][1]=(int) temp1.get(i);
                    k++;
                }
                hamo=0;
            }
        }

        return res;
    }
   public int[][] multiply(char poly1, char poly2)
   {
       DList temp1 =new DList();
       DList temp2 =new DList();
       if(poly1=='A'&&poly2=='B')
       {
           temp1 =yallaA;
           temp2=yallaB;
       }
       else if(poly1=='A'&&poly2=='C')
       {
           temp1=yallaA;
           temp2=yallaC;
       }
       else if(poly1=='B'&& poly2=='C' )
       {
           temp1=yallaB;
           temp2=yallaC;
       }
       int SizeTemp1 =temp1.size() ;
       int SizeTemp2 = temp2.size();
       int size=(SizeTemp1/2)*(SizeTemp2/2);
       int [][]res=new int[size][2];
       int [][] hamada= new int[size][2];
       int k=0,z=0;
       if (temp1.isEmpty()||temp2.isEmpty())
       {
           System.out.print("{"+0+","+0+"}");
           return res;
       }
       else
       {
           for (int i=1;i<SizeTemp1;i+=2)
           {
               for (int j=1;j<SizeTemp2;j+=2)
               {
                   hamada[k][0]=(int)temp1.get(i-1)*(int)temp2.get(j-1);
                   hamada[k][1]=(int)temp1.get(i)+(int)temp2.get(j);
                   k++;
               }
           }
           for (int i=0;i<size;i++)
           {
               for (int j=i+1;j<size;j++)
               {
                   if (hamada[i][1]==hamada[j][1])
                   {
                       hamada[i][0]+=hamada[j][0];
                       hamada[j][0]=0;
                       hamada[j][1]=0;
                   }
               }
           }
           for (int i=0;i<size;i++)
           {
               if (hamada[i][0]==0)
                   continue;
               for (int j=0;j<2;j++)
               {
                   res[z][j]=hamada[i][j];
               }
               z++;
           }
       }
    return res;
   }
   public String print(char poly) {
        int z = 0;
        DList temp = new DList();
        if (poly == 'A')
            temp = yallaA;
        if (poly == 'B')
            temp = yallaB;
        if (poly == 'C')
            temp = yallaC;
        if(poly=='R')
            temp=yallaR;
        String[] resutl = new String[this.o];
        for (int i = 0; i < this.o; i++) {
            int y = (int) temp.get(z);
            int w = (int) temp.get(z + 1);
            String x = Integer.toString(y);
            String t = Integer.toString(w);
            if (i == 0) {
                if (x.equals("0")) {
                    resutl[i] = "";
                } else if (x.equals("1") && t.equals("0")) {
                    resutl[i] = "1";
                } else if (x.equals("1") && t.equals("1")) {
                    resutl[i] = "x";
                } else if (x.equals("-1") && t.equals("0")) {
                    resutl[i] = "-1";
                } else if (x.equals("-1") && t.equals("1")) {
                    resutl[i] = "-x";
                } else if (x.equals("1")) {
                    resutl[i] = "x^" + t;
                } else if (x.equals("-1")) {
                    resutl[i] = "-x^" + t;
                } else if (t.equals("0")) {
                    resutl[i] = x;
                } else if (t.equals("1")) {
                    resutl[i] = x + "x";
                } else {
                    resutl[i] = x + "x^" + t;
                }
            } else {
                if (x.equals("1") && t.equals("0")) {
                    resutl[i] = "+1";
                } else if (x.equals("1") && t.equals("1")) {
                    resutl[i] = "+x";
                } else if (x.equals("-1") && t.equals("0")) {
                    resutl[i] = "-1";
                } else if (x.equals("0")) {
                    resutl[i] = "";
                } else if (x.equals("-1") && t.equals("1")) {
                    resutl[i] = "-x";
                } else if (x.equals("1")) {
                    resutl[i] = "+x^" + t;
                } else if (x.equals("-1")) {
                    resutl[i] = "-x^" + t;
                } else if (t.equals("0")) {
                    if (y>0) resutl[i] = "+"+x;
                    else resutl[i] = x;
                } else if (t.equals("1")) {
                    resutl[i] = "+" + x + "x";
                } else {
                    if (y > 0) {
                        resutl[i] = "+" + x + "x^" + t;
                    } else {
                        resutl[i] = x + "x^" + t;
                    }
                }
            }
            z = z + 2;
        }
        String final1 = "";
        for (int i = 0; i < this.o; i++) {
            final1 += resutl[i];
        }
        if (final1.charAt(0) == '+') {
            String final2 = "";
            for (int i = 1; i < final1.length(); i++) {
                final2 += final1.charAt(i);
            }
            return final2;
        }
        return final1;
    }
   public void clearPolynomial(char poly) {
        if (poly == 'A')
            yallaA.clear();
        if (poly == 'B')
            yallaB.clear();
        if (poly == 'C')
            yallaC.clear();
    }
   public float evaluatePolynomial(char poly, float value) {
        DList temp = new DList();
        if (poly == 'A')
            temp = yallaA;
        if (poly == 'B')
            temp = yallaB;
        if (poly == 'C')
            temp = yallaC;
        float result = (float) 0;
        int z = 0;
        for (int i = 0; i < this.o; i++) {
            int x = (int) temp.get(z);
            int y = (int) temp.get(z + 1);
            float r = 1;
            for (int counter = 0; counter < y; counter++)
                r = r * value;
            result += x * r;
            z += 2;
        }
        return result;
   }

}
