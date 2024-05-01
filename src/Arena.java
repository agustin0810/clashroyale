public class Arena {
    private char[][] arena;
    public char ganador = ' ';
    private int filaJugador;
    private int columnaJugador;
    private int filaMaquina = 0;
    private int columnaMaquina = 0;
    public Arena(int tamano){
        this.arena = new char[tamano==1?10:tamano==2?15:30][tamano==1||tamano==2?10:15];
        this.filaJugador = this.arena.length-1;
        this.columnaJugador = this.arena[0].length-1;
        fillArena();
    }
    private void fillArena(){
        for(int i =0;i<this.arena.length;i++){
            for(int j=0;j<this.arena[i].length;j++){
                this.arena[i][j] = '*';
            }
        }

        // Colocar obstáculos 'O'
        for (int i = 0; i < 2 + (int)(Math.random() * (arena.length / 3)); i++) {
            int x = (int)(Math.random() * this.arena.length);
            int y = (int)(Math.random() * this.arena[0].length);
            this.arena[x][y] = 'O';
        }

        // Colocar jugador 'P'
        int xPlayer = 1 + (int)(Math.random() * (this.arena.length - 1));
        int yPlayer = 1 + (int)(Math.random() * (this.arena[0].length - 1));
        this.arena[xPlayer][yPlayer] = 'P';
        this.arena[0][0] = 'M';
        this.arena[this.arena.length-1][this.arena[0].length-1] = 'J';

    }

    public void printArena(){
        for(int i =0; i<this.arena.length;i++){
            for(int j = 0; j<this.arena[i].length;j++){
                System.out.print(this.arena[i][j] +" ");
            }
            System.out.println("");
        }
    }

    public String hacerMovimiento(char movimiento, char jugador){
        switch(movimiento){
            case 'W':{
                int nuevaFila = getFila(jugador)-1;
                return moverJugador(getColumna(jugador), nuevaFila, jugador);
            }
            case 'A':{
                int nuevaColumna = getColumna(jugador)-1;
                return moverJugador(nuevaColumna, getFila(jugador), jugador);
            }
            case 'S':{
                int nuevaFila = getFila(jugador)+1;
                return moverJugador(getColumna(jugador), nuevaFila, jugador);
            }
            case 'D':{
                int nuevaColumna = getColumna(jugador)+1;
                return moverJugador(nuevaColumna, getFila(jugador), jugador);
            }
        }
        return "no movido";
    }

    private String moverJugador(int nuevaColumna, int nuevaFila, char jugador){
        int columnaActual = getColumna(jugador);
        int filaActual = getFila((jugador));
        if(nuevaColumna<arena[0].length && nuevaColumna>-1 && nuevaFila<arena.length && nuevaFila>-1){
            char valActual=arena[nuevaFila][nuevaColumna];
            if(valActual=='*'){
                arena[nuevaFila][nuevaColumna] = jugador;
                arena[filaActual][columnaActual] = valActual;
                if(jugador=='M'){
                    this.filaMaquina = nuevaFila;
                    this.columnaMaquina=nuevaColumna;
                }
                else{
                    this.filaJugador=nuevaFila;
                    this.columnaJugador=nuevaColumna;
                }
                return "movido";
            }
            else if(valActual=='P'){
                arena[nuevaFila][nuevaColumna] = jugador;
                arena[filaActual][columnaActual] = '*';
                if(jugador=='M'){
                    this.filaMaquina = nuevaFila;
                    this.columnaMaquina=nuevaColumna;
                }
                else{
                    this.filaJugador=nuevaFila;
                    this.columnaJugador=nuevaColumna;
                }
                return "bonus";
            }
            else{
                return "no movido";
            }
        }
        return "no movido";
    }
    public boolean hacerDisparo(char jugador){

        int fila = getFila(jugador);
        int columna = getColumna(jugador);
        if(jugador=='J'){
            for(int i = fila; i>-1; i--){
                if(arena[i][columna]=='O'){
                    return false;
                }
                else if(arena[i][columna]=='M'){
                    ganador = 'J';
                    return true;
                }
            }
            return false;
        }
        else{
            for(int i = fila; i< arena.length; i++){
                if(arena[i][columna]=='O'){
                    return false;
                }
                else if(arena[i][columna]=='J'){
                    ganador = 'M';
                    return true;
                }
            }
        }
        return false;
    }

    private int getColumna(char jugador){
        if(jugador=='J')
            return columnaJugador;
        else
            return columnaMaquina;
    }
    private int getFila(char jugador){
        if(jugador=='J')
            return filaJugador;
        else
            return filaMaquina;
    }
}
