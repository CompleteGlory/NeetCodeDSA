# Sorting Algorithms

Quick-recall notes for every sorting algorithm in this module. Each entry follows
the same template — copy the **Blueprint Template** at the bottom when you add a
new algorithm (sorting or otherwise) so notes stay consistent.

---

## Insertion Sort — `InsertionSort.java`

**Idea:** Grow a sorted region at the front of the array one element at a time.
Take the next element and slide it left past everything bigger than it.

**Steps:**
1. Start at index 1 (index 0 is trivially "sorted").
2. Compare the current element to the one before it.
3. While the previous element is bigger, swap them and step left.
4. Repeat for every index up to the end of the array.

**Complexity:** Time O(n²) worst/avg, O(n) best (already sorted) · Space O(1) · Stable · In-place

**Example:** `[3, 1, 2]`
- i=1: compare 1 vs 3 → swap → `[1, 3, 2]`
- i=2: compare 2 vs 3 → swap → `[1, 2, 3]`; compare 2 vs 1 → stop
- Result: `[1, 2, 3]`

**Core snippet:**
```java
for (int i = 1; i < arr.length; i++) {
    int j = i - 1;
    while (j >= 0 && arr[j + 1] < arr[j]) {
        swap(arr, j, j + 1);
        j--;
    }
}
```

**Memory hook:** *"Insert into the sorted pile, like sorting cards in your hand."*

---

## Quick Sort — `QuickSort.java`

**Idea:** Pick a pivot, partition the array so everything smaller is on the
left and everything bigger is on the right, then recurse on both halves.

**Steps:**
1. Pick the last element `arr[e]` as the pivot.
2. Walk the array with a `left` pointer; whenever a value is smaller than the
   pivot, swap it into the `left` slot and advance `left`.
3. After the scan, swap the pivot into position `left` — it's now in its
   final sorted spot.
4. Recurse on `[s, left-1]` and `[left+1, e]`.

**Complexity:** Time O(n log n) avg, O(n²) worst (bad pivots) · Space O(log n) (recursion stack) · Unstable · In-place

**Example:** `[3, 1, 2, 5, 4]`, pivot = `4`
- Scan s..e-1, move everything `< 4` to the front → `[3, 1, 2, 5]` becomes `[3,1,2]` left of `left`, `5` stays right
- Swap pivot into `left` slot → `[3, 1, 2, 4, 5]`
- Recurse on `[3,1,2]` and `[5]`

**Core snippet:**
```java
int pivot = arr[e];
int left = s;
for (int i = s; i < e; i++) {
    if (arr[i] < pivot) {
        swap(arr, left, i);
        left++;
    }
}
swap(arr, left, e); // drop pivot into its final spot
quickSort(arr, s, left - 1);
quickSort(arr, left + 1, e);
```

**Memory hook:** *"Pivot picks a side for everyone, then both sides sort themselves."*

---

## Merge Sort — `MergeSort.java`

**Idea:** Split the array in half recursively until pieces are size 1, then
merge sorted halves back together in order.

**Steps:**
1. Find the midpoint `m = (s+e)/2`.
2. Recursively sort the left half `[s, m]` and right half `[m+1, e]`.
3. Merge: copy both halves into temp arrays `L` and `R`, then walk both,
   picking the smaller front element each time back into `arr`.
4. Copy any leftover tail from `L` or `R`.

**Complexity:** Time O(n log n) always · Space O(n) (temp arrays) · Stable · Not in-place

**Example:** `[3, 1, 2]`
- Split → `[3]` and `[1, 2]` → split further → `[1]`, `[2]`
- Merge `[1]` + `[2]` → `[1, 2]`
- Merge `[3]` + `[1, 2]` → compare 3 vs 1 → 1, compare 3 vs 2 → 2, then 3 → `[1, 2, 3]`

**Core snippet:**
```java
int m = (s + e) / 2;
mergeSort(arr, s, m);
mergeSort(arr, m + 1, e);
merge(arr, s, m, e); // classic two-pointer merge into temp L/R arrays
```

**Memory hook:** *"Split until trivial, merge while comparing fronts."*

---

## Bucket / Counting Sort — `BucketSort.java`

**Idea:** When values are small non-negative integers in a known range
`[0, k)`, count how many times each value appears, then rebuild the array
by writing each value that many times in order. (Note: this implementation
is really **counting sort** — a frequency array, not literal buckets.)

**Steps:**
1. Make a `freq` array of size `k`.
2. For each element, increment `freq[value]`.
3. Walk `freq` from 0 to k-1; for each value `n`, write it `freq[n]` times
   back into the array.

**Complexity:** Time O(n + k) · Space O(k) · Stable (as written) · Only works for small-range non-negative ints

**Example:** `arr = [2,1,2,0,0,2]`, `k = 3`
- `freq = [2, 1, 3]` (two 0s, one 1, three 2s)
- Rebuild: write `0,0`, then `1`, then `2,2,2` → `[0, 0, 1, 2, 2, 2]`

**Core snippet:**
```java
int[] freq = new int[k];
for (int v : arr) freq[v]++;
int i = 0;
for (int n = 0; n < freq.length; n++) {
    for (int j = 0; j < freq[n]; j++) arr[i++] = n;
}
```

**Memory hook:** *"Count how many of each value, then stamp them back out in order."*

---

## Blueprint Template (copy for new algorithms)

```markdown
## <Algorithm Name> — `<FileName>.java`

**Idea:** <one sentence: the core trick>

**Steps:**
1. ...
2. ...

**Complexity:** Time O(...) · Space O(...) · Stable/Unstable · In-place/Not

**Example:** `<input array>`
- <walk through 2-4 key steps>
- Result: `<output>`

**Core snippet:**
\`\`\`java
// the 5-10 lines that capture the essence, not the whole file
\`\`\`

**Memory hook:** *"<short phrase that jogs your memory>"*
```
