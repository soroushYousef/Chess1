package Server;

import Common.User;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {


   public static ServerSocket userServerSocket;
   public static ServerSocket joinGameServerSocket;
   public static ServerSocket helpJoinGameServerSocket;

   public static Map<String, User> users = new ConcurrentHashMap<>();

   public static Map<User,JoinGameHandler> gameHandlers = new ConcurrentHashMap<>();
   //find other users to play
   public static Map<UserHandler,JoinGameHandler> joinGameHandlers= new ConcurrentHashMap<>();
   public static Map<UserHandler,HelpJoinGameHandler> helpJoinGameHandlerMap = new ConcurrentHashMap<>();

   public static void main(String args[]) {

       try {
            userServerSocket = new ServerSocket(9000);
            joinGameServerSocket = new ServerSocket(9001);
            helpJoinGameServerSocket =new ServerSocket(9002);

       } catch (IOException e) {
           e.printStackTrace();
       }


       while(true){
           try {
               //user hander thread start
               Socket userSocket = userServerSocket.accept();
               UserHandler userHandler = new UserHandler(userSocket);


               //join game handler thread
               Socket joinGameSocket = joinGameServerSocket.accept();
               JoinGameHandler joinGameHandler = new JoinGameHandler(joinGameSocket);
               joinGameHandlers.put(userHandler,joinGameHandler);

               //help join game handler thread
               Socket helpJoinGameSocket = helpJoinGameServerSocket.accept();
               HelpJoinGameHandler helpJoinGameHandler = new HelpJoinGameHandler(helpJoinGameSocket);
               helpJoinGameHandlerMap.put(userHandler,helpJoinGameHandler);


               //start threads
               new Thread(userHandler).start();
               new Thread(joinGameHandler).start();
               new Thread(helpJoinGameHandler).start();

           } catch (IOException e) {
               e.printStackTrace();
           }
       }

   }

   public static JoinGameHandler getJoinGameHandler(String userName){
       for(UserHandler userHandler : joinGameHandlers.keySet()){
           if(userHandler.getUser().getUserName().equals(userName)){
               return joinGameHandlers.get(userHandler);
           }
       }
       return null;
   }

   public  static <T> T getHandler(String userName,Map<UserHandler,T> map){
       for(UserHandler userHandler : map.keySet()){
           if(userHandler.getUser().getUserName().equals(userName)){
               return map.get(userHandler);
           }
       }
       return null;
   }

}
