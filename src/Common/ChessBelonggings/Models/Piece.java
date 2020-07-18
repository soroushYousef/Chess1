package Common.ChessBelonggings.Models;

import javax.swing.text.html.ImageView;



public class Piece {


   public enum PIECE_TYPE {
        SARBAZ,VAZIR,SHAH,PHIL,ROCKH,ASB
    }
    public enum COLOR{
        GREEN,GOLD
    }

    private PIECE_TYPE piece_type;
    private COLOR color;

    public Piece(PIECE_TYPE piece_type,COLOR color) {
        this.piece_type = piece_type;
        this.color = color;
    }

    public Piece(COLOR color){
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    public PIECE_TYPE getPiece_type() {
        return piece_type;
    }
}
