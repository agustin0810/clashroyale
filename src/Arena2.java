public class Arena2{
    private char[][] grid;
    private int width;
    private int height;

    public Arena2(int width, int height){
        this.width=width;
        this.height=height;
        grid = new char[height][width];
    }

    public void initializeGame(){
        for(int i =0; i<grid.length;i++){
            for(int j = 0; j<grid[i].length;j++){
                grid[i][j] = '*';
            }
        }
    }
    public void displayArena(){
        for(int i =0; i<grid.length;i++){
            for(int j = 0; j<grid[i].length;j++){
                System.out.print(grid[i][j]+" ");
            }
            System.out.println("");
        }
    }
}