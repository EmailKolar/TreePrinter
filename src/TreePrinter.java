import java.io.File;
import java.util.Objects;

public class TreePrinter {

    public static void main(String[] args) {
        System.out.println("Hello world!");
        if(args.length==0){
            System.out.println("for now please type path as parameter");
            System.out.println("type box for box drawing(separate from path with a space)");
        }
        String path = args[0];
        File directory = new File(path);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory: " + path);
            return;
        }
        if(args.length>1){
            if(Objects.equals(args[1], "box")){
                boxDrawTree(directory,"",false);
            }
        }else{
            tree(directory,0);

        }

    }

    private static void tree(File directory, int depth){
        File[] files = directory.listFiles();

        if(files != null){
            for (File file: files){
                for (int i = 0; i < depth; i++) {
                    System.out.print("    ");
                }
                System.out.println(file.getName());

                if(file.isDirectory()){
                    tree(file, depth+1);
                }
            }
        }

    }
    private static void boxDrawTree(File directory, String prefix, boolean isLast) {
        String line = prefix + (isLast ? "└─ " : "├─ ") + directory.getName();
        System.out.println(line);

        File[] files = directory.listFiles();

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                boolean lastItem = (i == files.length - 1);
                String newPrefix = prefix + (isLast ? "    " : "│   ");
                boxDrawTree(files[i], newPrefix, lastItem);
            }
        }
    }



}