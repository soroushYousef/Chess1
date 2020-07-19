package Client.Controller;


import Client.Model.Client;
import Common.ChessBelonggings.Models.Cell;
import Common.ChessBelonggings.Models.Piece;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;


public class GameController {

    ArrayList<ImageView> imageViews = new ArrayList<>();



    @FXML
    ImageView i1;


    @FXML
    ImageView i2;


    @FXML
    ImageView i3;


    @FXML
    ImageView i4;


    @FXML
    ImageView i5;


    @FXML
    ImageView i6;


    @FXML
    ImageView i7;


    @FXML
    ImageView i8;


    @FXML
    ImageView i9;


    @FXML
    ImageView i10;


    @FXML
    ImageView i11;


    @FXML
    ImageView i12;


    @FXML
    ImageView i13;


    @FXML
    ImageView i14;


    @FXML
    ImageView i15;


    @FXML
    ImageView i16;


    @FXML
    ImageView i17;


    @FXML
    ImageView i18;


    @FXML
    ImageView i19;


    @FXML
    ImageView i20;


    @FXML
    ImageView i21;


    @FXML
    ImageView i22;


    @FXML
    ImageView i23;


    @FXML
    ImageView i24;


    @FXML
    ImageView i25;


    @FXML
    ImageView i26;


    @FXML
    ImageView i27;


    @FXML
    ImageView i28;


    @FXML
    ImageView i29;


    @FXML
    ImageView i30;


    @FXML
    ImageView i31;


    @FXML
    ImageView i32;


    @FXML
    ImageView i33;


    @FXML
    ImageView i34;


    @FXML
    ImageView i35;


    @FXML
    ImageView i36;


    @FXML
    ImageView i37;


    @FXML
    ImageView i38;


    @FXML
    ImageView i39;


    @FXML
    ImageView i40;


    @FXML
    ImageView i41;


    @FXML
    ImageView i42;


    @FXML
    ImageView i43;


    @FXML
    ImageView i44;


    @FXML
    ImageView i45;


    @FXML
    ImageView i46;


    @FXML
    ImageView i47;


    @FXML
    ImageView i48;


    @FXML
    ImageView i49;


    @FXML
    ImageView i50;


    @FXML
    ImageView i51;


    @FXML
    ImageView i52;


    @FXML
    ImageView i53;


    @FXML
    ImageView i54;


    @FXML
    ImageView i55;


    @FXML
    ImageView i56;


    @FXML
    ImageView i57;


    @FXML
    ImageView i58;


    @FXML
    ImageView i59;


    @FXML
    ImageView i60;


    @FXML
    ImageView i61;


    @FXML
    ImageView i62;


    @FXML
    ImageView i63;


    @FXML
    ImageView i64;






    @FXML
    GridPane gridPane;

    private boolean isSelected = false;
    public static ImageView selected;
    //private Cell[][] cells;
     ArrayList<Cell>   cells = new ArrayList<>();

    public void initialize(){
    gridPane.getStylesheets().addAll(getClass().getResource("/css/GamePageStyle.css").toExternalForm());


        imageViews.add(i1);
        imageViews.add(i2);
        imageViews.add(i3);
        imageViews.add(i4);
        imageViews.add(i5);
        imageViews.add(i6);
        imageViews.add(i7);
        imageViews.add(i8);
        imageViews.add(i9);
        imageViews.add(i10);
        imageViews.add(i11);
        imageViews.add(i12);
        imageViews.add(i13);
        imageViews.add(i14);
        imageViews.add(i15);
        imageViews.add(i16);
        imageViews.add(i17);
        imageViews.add(i18);
        imageViews.add(i19);
        imageViews.add(i20);
        imageViews.add(i21);
        imageViews.add(i22);
        imageViews.add(i23);
        imageViews.add(i24);
        imageViews.add(i25);
        imageViews.add(i26);
        imageViews.add(i27);
        imageViews.add(i28);
        imageViews.add(i29);
        imageViews.add(i30);
        imageViews.add(i31);
        imageViews.add(i32);
        imageViews.add(i33);
        imageViews.add(i34);
        imageViews.add(i35);
        imageViews.add(i36);
        imageViews.add(i37);
        imageViews.add(i38);
        imageViews.add(i39);
        imageViews.add(i40);
        imageViews.add(i41);
        imageViews.add(i42);
        imageViews.add(i43);
        imageViews.add(i44);
        imageViews.add(i45);
        imageViews.add(i46);
        imageViews.add(i47);
        imageViews.add(i48);
        imageViews.add(i49);
        imageViews.add(i50);
        imageViews.add(i51);
        imageViews.add(i52);
        imageViews.add(i53);
        imageViews.add(i54);
        imageViews.add(i55);
        imageViews.add(i56);
        imageViews.add(i57);
        imageViews.add(i58);
        imageViews.add(i59);
        imageViews.add(i60);
        imageViews.add(i61);
        imageViews.add(i62);
        imageViews.add(i63);
        imageViews.add(i64);



        for(ImageView imageView : imageViews){
        cells.add(new Cell(imageView,null));
    }

    for(int i = 0;i<16;i++){
        cells.get(i).setPiece(new Piece(Piece.COLOR.GREEN));
    }

    for(int i = 56;i<64;i++){
        cells.get(i).setPiece(new Piece(Piece.COLOR.GOLD));
    }



   getAnswer.start();



    }

    Thread getAnswer=new Thread(new Runnable() {
        @Override
        public void run() {
            try{
                while(true) {
                    String answer = Client.gameIn.readUTF();
                    String[] array = answer.split("@");

                    ImageView first = getImageView(array[0]);
                    ImageView second = getImageView(array[1]);

                    second.setImage(first.getImage());
                    first.setImage(null);


                }

            }
            catch (IOException e){
                e.printStackTrace();
            }



        }
    });








    public void click(MouseEvent mouseEvent) {
        if(isSelected){
            ImageView temp = (ImageView) mouseEvent.getSource();

            try {
                //new Alert(Alert.AlertType.ERROR,selected.getId()).showAndWait();
                //new Alert(Alert.AlertType.ERROR,temp.getId()).showAndWait();
             //   new Alert(Alert.AlertType.ERROR,imageViews.toString()).showAndWait();
             //   new Alert(Alert.AlertType.ERROR,String.format("%d",imageViews.size())).showAndWait();
             //   new Alert(Alert.AlertType.ERROR,getImageView(temp.getId()).getId()).showAndWait();
                Client.gameOut.writeUTF("move@"+selected.getId() + "@" + temp.getId()+ "@"+ (temp.getImage() == null ? "normal" : "attack"  ));
            } catch (IOException e) {
                e.printStackTrace();
            }
            temp.setImage(selected.getImage());
            selected.setImage(null);
            selected = null;
            isSelected=false;
        }
        else {
            isSelected = true;
            selected = ((ImageView) mouseEvent.getSource());
          //  new Alert(Alert.AlertType.ERROR,selected.getId()).showAndWait();
        }
    }

    public Cell findCell(ImageView imageView){
        for(Cell cell : cells){
            if(cell.getImageView().equals(imageView)){

                return cell;
            }
        }
        return null;
    }
    public ImageView getImageView(String id){
        for(ImageView imageView : imageViews){
            if(imageView.getId().equals(id)){
                return imageView;
            }
        }
        return null;
    }

    public void abandon(ActionEvent actionEvent) {
    }
}
