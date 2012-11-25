/**
 * Created with IntelliJ IDEA.
 * User: Администратор
 * Date: 03.11.12
 * Time: 18:36
 * To change this template use File | Settings | File Templates.
 */
public class ExampleBuilder implements Cloneable {
    private final int firstField;
    private final int secondParametr;
    private final int thirdParametr;
    private final int fourthParametr;

    @Override
    public ExampleBuilder clone(){

        return new BuilderExample(12,12).build();
    }
    public static class BuilderExample{
        private int firstField;
        private int secondParametr;
        private int thirdParametr = 0;
        private int fourthParametr = 0;

        public BuilderExample(int first, int second){
            this.firstField = first;
            this.secondParametr = second;
        }
        public BuilderExample third(int third){
            thirdParametr = third;
            return this;
        }
        public BuilderExample fourth(int fourth){
            thirdParametr = fourth;
            return this;
        }
        public ExampleBuilder build(){
            return new ExampleBuilder(this);
        }
    }
    public ExampleBuilder(BuilderExample example){
        this.firstField = example.firstField;
        this.secondParametr = example.secondParametr;
        this.thirdParametr = example.thirdParametr;
        this.fourthParametr = example.fourthParametr;
    }
    @Override
    public String toString(){
        return String.valueOf(firstField) + String.valueOf(secondParametr)
                + String.valueOf(thirdParametr) + String.valueOf(fourthParametr);
    }

    public static void main(String[] args) {
        ExampleBuilder exampleBuilder = new ExampleBuilder.BuilderExample(1,20).third(2).fourth(12).build();
        System.out.println(exampleBuilder.toString());
        Integer i1 = 1;
        Integer i2 = 1;
        System.out.println("i1>=i2: "+(i1>=i2));
        System.out.println("i1<=i2: "+(i1<=i2));
        System.out.println("i1==i2: "+(i1==i2));
    }

}
