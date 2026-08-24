public class main {
    public static void main(String[] args) {
        MemoriaS hd  = new HD("46327",10,MemoriaS.MB); 
        MemoriaS cd = new CD(650,MemoriaS.MB); 

        ImprimirHd(hd);
        ImprimirCd(cd);

    }

    public static void ImprimirCd(MemoriaS cd){
        CD cdReal = (CD) cd;
        System.out.println("estado do cd: " + cdReal.getEstado());
        System.out.println(cd);
        

    }

    public static void ImprimirHd(MemoriaS hd){
        HD hdReal = (HD) hd;
       System.out.println("Numero de Serie do HD " + hdReal.getNumeroSerie() + " Percentual Disponível " + hd.getPerda());
       System.out.println(hdReal);

    }
}
