package Server;

import Common.Game;
import Common.User;
import Server.Communication.GameHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Server {


   public static ServerSocket userServerSocket;
   public static ServerSocket joinGameServerSocket;
   public static ServerSocket gameServerSocket;
   public static ServerSocket helpJoinGameServerSocket1;

   public static Map<String, User> users = new ConcurrentHashMap<>();
   public static Map<String, Game> games = new ConcurrentHashMap<>();

   public static Map<User,JoinGameHandler> gameHandlers = new ConcurrentHashMap<>();
   //find other users to play
   public static Map<UserHandler,JoinGameHandler> joinGameHandlers= new ConcurrentHashMap<>();
   //
   public static Map<UserHandler, GameHandler> gameHandlerMap = new ConcurrentHashMap<>();
   //public static  Map<UserHandler,HelpJoinGameHandler1> helpJoinGameHandler1Map = new ConcurrentHashMap<>();

   public static void main(String args[]) {

       try {
            userServerSocket = new ServerSocket(9000);
            joinGameServerSocket = new ServerSocket(9001);
            gameServerSocket =new ServerSocket(9002);
           // helpJoinGameServerSocket1 = new ServerSocket(9003);


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

               //game handler thread
               Socket gameSocket = gameServerSocket.accept();
               GameHandler gameHandler = new GameHandler(gameSocket);
                gameHandlerMap.put(userHandler,gameHandler);


               //
               //Socket helpJoinGameSocket1 = helpJoinGameServerSocket1.accept();
               //HelpJoinGameHandler1 helpJoinGameHandler1 = new HelpJoinGameHandler1(helpJoinGameSocket1);
               //helpJoinGameHandler1Map.put(userHandler,helpJoinGameHandler1);

               //start threads
               new Thread(userHandler).start();
               new Thread(joinGameHandler).start();
                new Thread(gameHandler).start();

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

   public static Game getGame(User user1,User user2){
       Game temp = new Game(user1,user2);
       for(Game game : games.values()){
           if(game.equals(temp)){
               return game;
           }
       }
       return null;
   }

}
