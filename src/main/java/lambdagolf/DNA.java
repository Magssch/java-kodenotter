package lambdagolf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class DNA {

    private List<String> genes = new ArrayList<>();
    private static String nucleobases = "ATGC";

    public List<String> getAllMatchingGenes(Predicate<String> predicate) {
        return genes.stream()
                    .filter(predicate)
                    .collect(Collectors.toList());
    }

    public void addGene(String gene) {
        if (genes.contains(gene)) {
            return;
        }
        if (genes.contains(gene) ||
            gene.length() < 1 ||
            gene.chars()
                .mapToObj(charInt -> Character.toString((char) charInt))
                .anyMatch(nucleobase -> !nucleobases.contains(nucleobase))
        ) {
            return;
        }
        genes.add(gene);
    }

    public void reorder(Comparator<String> stringComparator) {
        genes.sort(stringComparator);
    }

    public boolean containsCodon(String codon) {
        if (codon.length() != 3) {
            return false;
        }
        return genes.stream()
                    .anyMatch(gene -> gene.contains(codon));
    }

    public String transcribeToRNA() {
        return this.toCharStream()
                   .map(nucleobase -> getComplement(nucleobase))
                   .map(nucleobase -> nucleobase.equals('T') ? "U" : Character.toString(nucleobase))
                   .reduce("", (RNA, nucleobase) -> RNA + nucleobase);
    }

    public String getStrand() {
        return String.join("", genes);
    }

    public String getComplementaryStrand() {
        return this.toCharStream()
                   .map(nucleobase -> Character.toString(getComplement(nucleobase)))
                   .reduce("", (gene, nucleobase) -> gene + nucleobase);
    }

    public char getComplement(char nucleobase) {
        return switch(nucleobase) {
            case 'A' -> 'T';
            case 'T' -> 'A';
            case 'G' -> 'C';
            case 'C' -> 'G';
            default -> 'X';
        };
    }

    private Stream<Character> toCharStream() {
        return genes.stream()
                    .flatMap(gene -> gene.chars()
                    .mapToObj(charInt -> (char) charInt));
    }

    @Override
    public String toString() {
        return getStrand() + "\n" + getComplementaryStrand();
    }
}
