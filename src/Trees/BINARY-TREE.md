# Binary Tree Algorithms

Quick-recall notes for every Binary Tree and Binary Search Tree (BST) algorithm in this module. Each entry follows the same template so future additions remain consistent.

---

## Insert into BST — `insertBST()`

### Idea

Walk down the tree until you find a null position where the value belongs.

### Steps

1. If the root is null, create a new node.
2. If `val` is greater than the current node, recurse right.
3. If `val` is less than the current node, recurse left.
4. Return the root.

### Complexity

- Time: `O(h)` (height of tree)
- Space: `O(h)` (recursive stack)
- BST Operation

### Example

Insert:

```text
50, 30, 70, 20, 40
```

Result:

```text
      50
     /  \
   30    70
  / \
20  40
```

### Core Snippet

```java
if (root == null) {
    return new TreeNode(val);
}

if (root.val < val) {
    root.right = insertBST(root.right, val);
} else if (root.val > val) {
    root.left = insertBST(root.left, val);
}
```

### Memory Hook

> "Keep going left or right until you hit an empty spot."

---

## Remove from BST — `removeBST()`

### Idea

Find the node, then handle one of three cases:

1. No children
2. One child
3. Two children

### Steps

1. Search for the node.
2. If it has no children, return `null`.
3. If it has one child, return that child.
4. If it has two children:
    - Find the minimum value in the right subtree.
    - Replace the node's value.
    - Delete the duplicate value from the right subtree.

### Complexity

- Time: `O(h)`
- Space: `O(h)`

### Example

Delete `50`

```text
      50
     /  \
   30    70
        /  \
      60    80
```

Find minimum in right subtree:

```text
60
```

Replace:

```text
      60
     /  \
   30    70
          \
          80
```

### Core Snippet

```java
TreeNode min = findMinOfBST(root.right);
root.val = min.val;
root.right = removeBST(root.right, min.val);
```

### Memory Hook

> "Replace with the next biggest value."

---

## Search in BST — `BstSearch()`

### Idea

Use BST ordering to eliminate half the tree on every comparison.

### Steps

1. If node is null, return false.
2. If target is larger, go right.
3. If target is smaller, go left.
4. Otherwise, found it.

### Complexity

- Time: `O(h)`
- Space: `O(h)`

### Example

Search for `40`

```text
      50
     /  \
   30    70
     \
      40
```

Traversal:

```text
50 -> 30 -> 40
```

### Core Snippet

```java
if (target > root.val) {
    return BstSearch(root.right, target);
} else if (target < root.val) {
    return BstSearch(root.left, target);
}
return true;
```

### Memory Hook

> "BSTs let you ignore half the tree."

---

## Find Minimum in BST — `findMinOfBST()`

### Idea

The smallest value is always the leftmost node.

### Steps

1. Start at the root.
2. Keep moving left.
3. Stop when `left == null`.

### Complexity

- Time: `O(h)`
- Space: `O(1)`

### Example

```text
       50
      /
    30
   /
 10
```

Result:

```text
10
```

### Core Snippet

```java
while (cur != null && cur.left != null) {
    cur = cur.left;
}
```

### Memory Hook

> "Minimum is all the way left."

---

## Inorder Traversal — `inorder()`

### Idea

Visit:

```text
Left -> Root -> Right
```

For BSTs, this produces sorted order.

### Complexity

- Time: `O(n)`
- Space: `O(h)`

### Example

```text
    2
   / \
  1   3
```

Output:

```text
1 2 3
```

### Core Snippet

```java
inorder(root.left);
System.out.println(root.val);
inorder(root.right);
```

### Memory Hook

> "Inorder = sorted BST."

---

## Preorder Traversal — `preorder()`

### Idea

Visit:

```text
Root -> Left -> Right
```

Useful for copying or serializing trees.

### Complexity

- Time: `O(n)`
- Space: `O(h)`

### Example

```text
    2
   / \
  1   3
```

Output:

```text
2 1 3
```

### Core Snippet

```java
System.out.println(root.val);
preorder(root.left);
preorder(root.right);
```

### Memory Hook

> "Pre = print first."

---

## Postorder Traversal — `postorder()`

### Idea

Visit:

```text
Left -> Right -> Root
```

Useful for deletion and cleanup.

### Complexity

- Time: `O(n)`
- Space: `O(h)`

### Example

```text
    2
   / \
  1   3
```

Output:

```text
1 3 2
```

### Core Snippet

```java
postorder(root.left);
postorder(root.right);
System.out.println(root.val);
```

### Memory Hook

> "Post = print last."

---

## Breadth-First Search (Level Order Traversal) — `BFS()`

### Idea

Traverse the tree level by level using a queue.

### Steps

1. Put the root in the queue.
2. Process every node in the current level.
3. Add children to the queue.
4. Repeat until empty.

### Complexity

- Time: `O(n)`
- Space: `O(w)` (`w` = maximum width)

### Example

```text
        1
      /   \
     2     3
    / \   /
   4  5  6
```

Output:

```text
[
 [1],
 [2,3],
 [4,5,6]
]
```

### Core Snippet

```java
Queue<TreeNode> queue = new LinkedList<>();
queue.offer(root);

while (!queue.isEmpty()) {
    int size = queue.size();

    for (int i = 0; i < size; i++) {
        TreeNode cur = queue.poll();

        if (cur.left != null)
            queue.offer(cur.left);

        if (cur.right != null)
            queue.offer(cur.right);
    }
}
```

### Memory Hook

> "Queues process trees level by level."

---

## Tree Printing — `print()`

### Idea

Render the tree as a human-readable 2D diagram.

### Example

```text
         _______80_______
        /                \
      _48_             _92_
     /    \           /    \
    35    52         82    98
      \     \
      40    53
```

### Complexity

- Time: `O(n)`
- Space: `O(n)`

### Memory Hook

> "Visualize the tree instead of imagining it."

---

## Blueprint Template

```markdown
## <Algorithm Name> — `<MethodName>()`

### Idea

<one sentence>

### Steps

1. ...
2. ...

### Complexity

- Time: O(...)
- Space: O(...)

### Example

```text
<tree>
```

Output:

```text
...
```

### Core Snippet

```java
// essential logic
```

### Memory Hook

> "<short phrase>"
```