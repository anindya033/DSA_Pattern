# Dynamic Programming (DP)

Dynamic Programming is a technique to solve problems by **breaking them into overlapping subproblems** and using **optimal substructure**.  
Instead of solving the same subproblem multiple times, results are stored and reused.

---

## Recursion
- Solve a problem by breaking it into smaller subproblems.
- Straightforward but may recompute subproblems many times.
- Time complexity often becomes **exponential**.

---

## Memoization (Top-Down DP)
- Recursion + caching (storing answers of subproblems).
- Use a **DP array/hashmap** to store intermediate results.
- Before computing a subproblem, check if already solved.
- Time complexity reduces (often **O(n)** instead of **O(2^n)**).

---

## Tabulation (Bottom-Up DP)
- Iterative (no recursion).
- Solve smallest subproblems first and build answers for larger ones.
- Use a **DP table/array** filled step by step.
- Often more efficient in practice than recursion + memoization.

---

## Space Optimization
- If only a few previous states are required, reduce memory.
- Replace DP table with variables (e.g., only 2 variables for Fibonacci).
- Saves space without increasing time complexity.

---

## Converting Between Approaches

### Recursion → Memoization
- Identify base cases.
- Add a DP array/map initialized with default values (e.g., -1).
- Before solving a subproblem, check if result is cached.
- Store the result before returning.

### Memoization → Tabulation
- Identify DP dimensions.
- Convert recursive relation into iterative loops.
- Initialize base cases in the DP array.
- Fill the array in increasing order of subproblem size.

### Tabulation → Space Optimization
- Check dependency of state transitions.
- If only last 1–2 rows/values are needed, replace DP array with variables.
- Update variables step by step.

---
