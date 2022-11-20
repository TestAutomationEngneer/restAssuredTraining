//package utils;
//
//public class ThreadLocalExample {
//
//    public static void main(String[] args) {
//        ThreadLocal friends = new ThreadLocal();
//
//        // Przypisanie wartość do ThreadLocal - z rzutowanie
//
//        friends.set("Ros");
//        // to samo tylko że z Lambda
//        //ThreadLocal friends2 = ThreadLocal.withInitial(() -> "Phebe");
//
//        //Object o = friends.get();  // domyśłnie jest tam typ Object, potrzebne rzutowanie do String
//
//        String friend1 = (String) friends.get();
//        System.out.println(friend1);
//
//        friends.remove();
//        System.out.println((String) friends.get());
//
// // 2. Przypisanie wartośc z typem generycznycm, nie trzeba rzutować
//
//        ThreadLocal<String> friends3 = new ThreadLocal<>();
//        friends3.set("Joe");
//
//        System.out.println(friends3.get());
//    }
//}
