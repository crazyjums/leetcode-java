package utils;


public class Person {
    private Person(){}

    //method 1
//    private static Person person = new Person();
//
//    public static Person getInstance(){
//        return person;
//    }
    //method2
//    private static volatile Person person;
//    public static Person getInstance(){
//        if (person==null)
//            synchronized (Person.class){
//                if (person==null)
//                    person=  new Person();
//        }
//        return person;
//    }

    //method3

    private static class inner{
        private static final Person SINGLETON = new Person();
    }

    public static Person getInstance(){
        return inner.SINGLETON;
    }

}
