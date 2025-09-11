package lesson3;

//Если не абстрактный то нужен в switch default или case SealedExpr se
//А в абстрактном не надо default или case SealedExpr se
public sealed class SealedExpr permits Num,Sum,Multiply{
    public static void main(String[] args) {
        SealedExpr expr = new Num();
        switch (expr) {
            case Num n -> System.out.println( "Num");
            case Sum s -> System.out.println( "Sum");
            case Multiply m -> System.out.println( "Multiply");
            default -> throw new IllegalStateException("Unexpected value: " + expr);
//            case SealedExpr se -> System.out.println( "SealedExpr");
        };
    }
}
final class Num extends SealedExpr{}
final class Sum extends SealedExpr{}
final class Multiply extends SealedExpr{}
