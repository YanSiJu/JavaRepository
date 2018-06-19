package sample;
public class SimpleCalculator{
        private String first;
        private String second;
        private double result;
        private String operator;
        public void setFirst(String first) { this.first=first;}
        public void setSecond(String second) { this.second=second; }
        public void setOperator(String operator) { this.operator=operator; }
        public String getFirst() { return this.first;}
        public String getSecond(){ return this.second;}
        public String getOperator() { return this.operator;}
        public double getResult() { return this.result; }
        public void calculate()    {
                double one=Double.parseDouble(first);
                double two=Double.parseDouble(second);
                try {
                         if(operator.equals("+")) result=one+two;
                         else if(operator.equals("-"))result=one-two;
                                else if(operator.equals("*"))result=one*two;
                                else if(operator.equals("/"))result=one/two;
              } catch(Exception e) { e.printStackTrace(); }  
}
}
