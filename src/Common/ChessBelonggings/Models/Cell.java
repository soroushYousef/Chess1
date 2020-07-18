package Common.ChessBelonggings.Models;


import javafx.scene.image.ImageView;

public class Cell {

   enum MOVE_STATUE{
      ATTACK,NORMAL
   }

   private ImageView imageView;
   private Piece piece;

   public Cell(ImageView imageView,Piece piece){
      this.imageView = imageView;
      this.piece = piece;
   }


   public MOVE_STATUE moveStatue(Cell first, Cell second){
      if(second.getPiece() != null){
         return MOVE_STATUE.ATTACK;
      }
      else {
         return MOVE_STATUE.NORMAL;
      }
   }

   public MOVE_STATUE moveStatue(Cell cell){
      if(cell.getImageView().getImage() != null){
         return MOVE_STATUE.ATTACK;
      }
      else {
         return MOVE_STATUE.NORMAL;
      }
   }


   public void move(Cell first,Cell second){
      second.getImageView().setImage(first.getImageView().getImage());
      first.getImageView().setImage(null);
   }

   public void move(Cell cell){
      cell.getImageView().setImage(imageView.getImage());
      this.imageView.setImage(null);
   }


   public ImageView getImageView(){
      return imageView;
   }

   public Piece getPiece(){
      return piece;
   }

   public void setPiece(Piece piece){
      this.piece = piece;
   }

}
