class Heap:

    def __init__(self):
        self.storage = []

    def isEmpty(self):
        return len(self.storage) <= 0

    def getParentIdx(self, idx):
        return (idx - 1) // 2    

    def getLeftChildIdx(self, idx):
        return 2 * idx + 1

    def getRightChildIdx(self, idx):
        return 2 * idx + 2

    def hasParent(self, idx):
        return self.getParentIdx(idx) >= 0

    def hasLeftChild(self, idx):
        return self.getLeftChildIdx(idx) < len(self.storage) 

    def hasRightChild(self, idx):
        return self.getRightChildIdx(idx)  < len(self.storage)

    def getParentElement(self, idx):
        return self.storage[self.getParentIdx(idx)]

    def getLeftChildElement(self, idx):
        return self.storage[self.getLeftChildIdx(idx)]

    def getRightChildElement(self, idx):
        return self.storage[self.getRightChildIdx(idx)]

    def swap(self, i, j):
        temp = self.storage[i]
        self.storage[i] = self.storage[j]
        self.storage[j] = temp


    def insert(self, data):
        self.storage.append(data)
        self.heapifyUp()


    def heapifyUp(self):
        idx = len(self.storage) -1
        while self.hasParent(idx) and self.getParentElement(idx).lb > self.storage[idx].lb:
            self.swap(self.getParentIdx(idx), idx)
            idx = self.getParentIdx(idx)


    def removeMin(self):
        if(self.isEmpty()):
            raise("Empty heap")                          
        
        data = self.storage[0]
        self.storage[0] = self.storage[len(self.storage) - 1]
        self.storage.pop()
        self.heapifyDown()

        return data


    def heapifyDown(self):
        
        idx = 0

        while self.hasLeftChild(idx):
            smallerChildIdx = self.getLeftChildIdx(idx)
            if self.hasRightChild(idx) and self.getRightChildElement(idx).lb < self.getLeftChildElement(idx).lb:
                smallerChildIdx = self.getRightChildIdx(idx)

            if self.storage[idx].lb < self.storage[smallerChildIdx].lb:
                break
            else:
                self.swap(idx, smallerChildIdx)        

            idx = smallerChildIdx 


class Item:

    def __init__(self, lb, ub):
        self.lb = lb
        self.ub = ub

item1 = Item(5,5)
item2 = Item(3,3)
item3 = Item(6,6)


heap = Heap()

heap.insert(item1)
heap.insert(item2)
heap.insert(item3)


print(heap.removeMin().lb)
print(heap.removeMin().lb)

for i in heap.storage:
    print(str(i.lb) + "**")