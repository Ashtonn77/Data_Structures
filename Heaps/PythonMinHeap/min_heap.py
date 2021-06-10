class MinHeap:

    def __init__(self, capacity):
        self.storage = [0] * capacity
        self.capacity = capacity
        self.size = 0

    def getParentIdx(self, index):
        return (index - 1) // 2

    def getLeftChildIdx(self, index):
        return 2 * index + 1

    def getRightChildIdx(self, index):
        return 2 * index + 2

    def hasParent(self, index):
        return self.getParentIdx(index) >= 0

    def hasLeftChild(self, index):
        return self.getLeftChildIdx(index) < self.size

    def hasRightChild(self, index):
        return self.getRightChildIdx(index) < self.size

    def getParent(self, index):
        return self.storage[self.getParentIdx(index)]

    def getLeftChild(self, index):
        return self.storage[self.getLeftChildIdx(index)]

    def getRightChild(self, index):
        return self.storage[self.getRightChildIdx(index)]

    def isFull(self):
        return self.size == self.capacity

    def swap(self, idx_1, idx_2):
        temp = self.storage[idx_1]
        self.storage[idx_1] = self.storage[idx_2]
        self.storage[idx_2] = temp

    def insert(self, data):
        if(self.isFull()):
            raise("Heap is full")
        self.storage[self.size] = data;
        self.size += 1
        self.heapifyUp()

    def heapifyUp(self):
        index = self.size - 1
        while self.hasParent(index) and self.getParent(index) > self.storage[index]:
            self.swap(self.getParentIdx(index), index)
            index = self.getParentIdx(index)                                            


    def removeMin(self):
        if self.size == 0:
            raise("Empty heap")

        data = self.storage[0]
        self.storage[0] = self.storage[self.size-1]
        self.storage[self.size - 1] = 0
        self.size -= 1    
        self.heapifyDown()
        return data

    def heapifyDown(self):
        index = 0

        while self.hasLeftChild(index):
            smallerChildIndex = self.getLeftChildIdx(index)
            if self.hasRightChild(index) and self.getRightChild(index) < self.getLeftChild(index):
                smallerChildIndex = self.getRightChild(index)

            if self.storage[index] < self.storage[smallerChildIndex]:
                break
            else:
                self.swap(index, smallerChildIndex)   

            index = smallerChildIndex


heap = MinHeap(5)

heap.insert(15)
heap.insert(150)
heap.insert(10)

print(heap.removeMin())

print(heap.storage)
