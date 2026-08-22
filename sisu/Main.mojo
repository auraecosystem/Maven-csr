# Save as main.mojo
from sys import info

# 1. Custom struct with value semantics (automatically synthesizes constructors & copies)
@value
struct Point:
    var x: Float32
    var y: Float32

    # 'fn' enforces strict compile-time type checking and zero-overhead execution
    fn distance_from_origin(self) -> Float32:
        return (self.x * self.x + self.y * self.y).sqrt()

# 2. SIMD Vectorization
fn fast_add_vectors(a: Float32, b: Float32) -> SIMD[DType.float32, 4]:
    # Creates 4-element SIMD vectors initialized with values 'a' and 'b'
    var vec_a = SIMD[DType.float32, 4](a)
    var vec_b = SIMD[DType.float32, 4](b)
    
    # Executes vector addition across CPU vector registers in a single instruction
    return vec_a + vec_b

# 3. Main execution entry point
fn main():
    # 'let' for immutable bindings, 'var' for mutable variables
    let origin_point = Point(3.0, 4.0)
    print("Point distance to origin:", origin_point.distance_from_origin())

    var val1: Float32 = 12.5
    var val2: Float32 = 7.5
    let simd_result = fast_add_vectors(val1, val2)
    
    print("SIMD Result (4-lane vector):", simd_result)
