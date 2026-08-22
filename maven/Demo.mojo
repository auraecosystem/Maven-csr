from algorithm import parallelize

@value
struct Point:
    var x: Float32
    var y: Float32

    fn distance_from_origin(self) -> Float32:
        return (self.x * self.x + self.y * self.y).sqrt()

fn main():
    let num_items = 8

    # The worker function must be marked @parameter to allow compile-time specialization
    @parameter
    fn worker(index: Int):
        let p = Point(Float32(index), Float32(index * 2))
        let dist = p.distance_from_origin()
        print("Index:", index, "| Distance:", dist)

    # Distributes execution of 'worker' across all available CPU threads
    parallelize[worker](num_items)
