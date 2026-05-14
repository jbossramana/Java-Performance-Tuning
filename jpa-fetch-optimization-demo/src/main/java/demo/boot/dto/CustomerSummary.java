package demo.boot.dto;



public record CustomerSummary(
        String customerName,
        long orderCount
) {
}
