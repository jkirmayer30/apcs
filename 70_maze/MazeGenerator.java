public class MazeGenerator{
  int h;
  int w;
  public char[][] newMaze(int x,int y){
    char[][] maze = new char[x][y];
    x=w;
    y=h;
    boolean finished  = false;
    for (int i = 0;i < x;i++){
      for (int j = 0; j < y ; j++){
        if (i<1 || j<1 || i>x-2|| j>y-2){
          maze[i][j] = ' ';
        } else {
          int rand = Math.random();
          if (!finished&&i==x-1&&j==y-1){
            maze[i][j]='$';
            finished = true;
          } else if (!finished&&rand>0.97){
            maze[i][j]='$';
            finished = true;
          } else if (rand>0.7){
            maze[i][j]='#';
          } else {
            maze[i][j]=' ';
          }
        }
      }
    }

    public String toString()
    {
      //send ANSI code "ESC[0;0H" to place cursor in upper left
      String retStr = "[0;0H";
      //emacs shortcut: C-q, ESC
      //emacs shortcut: M-x quoted-insert, ESC

      int i, j;
      for( i=0; i<h; i++ ) {
        for( j=0; j<w; j++ )
          retStr = retStr + Character.toString(maze[j][i]);
        retStr = retStr + "\n";
      }
      return retStr;
    }

    return maze;
  }
}
