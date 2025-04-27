// Function to calculate sum of interior angles
fun calculateInteriorAngleSum(sides: Int): Int {
    return (sides - 2) * 180
}

// Function to calculate salary based on days worked
fun calculateSalary(days: Int): Double {
    val totalHours = days * 8
    return if (totalHours <= 160) {
        totalHours * 10.0
    } else {
        (160 * 10.0) + ((totalHours - 160) * 20.0)
    }
}

// Function to calculate internet fee based on quota
fun calculateInternetFee(gigabytesUsed: Int): Double {
    return if (gigabytesUsed <= 50) {
        100.0
    } else {
        100.0 + ((gigabytesUsed - 50) * 4.0)
    }
}

// Function to convert Celsius to Fahrenheit
fun convertToFahrenheit(celsius: Double): Double {
    return celsius * 1.8 + 32
}

// Function to calculate perimeter of rectangle
fun calculateRectanglePerimeter(length: Double, width: Double): Double {
    return 2 * (length + width)
}

// Function to calculate factorial of a number
fun calculateFactorial(number: Int): Long {
    if (number <= 1) return 1
    var result: Long = 1
    for (i in 2..number) {
        result *= i
    }
    return result
}

// Function to count occurrences of letter 'a' in a word
fun countLetterA(word: String): Int {
    return word.count { it == 'a' || it == 'A' }
}

fun main() {
    // Test calculateInteriorAngleSum
    val triangleAngles = calculateInteriorAngleSum(3)
    val hexagonAngles = calculateInteriorAngleSum(6)
    println("Sum of interior angles in a triangle: $triangleAngles degrees")
    println("Sum of interior angles in a hexagon: $hexagonAngles degrees")

    // Test calculateSalary
    val regularSalary = calculateSalary(20) // 20 days = 160 hours (no overtime)
    val overtimeSalary = calculateSalary(25) // 25 days = 200 hours (40 hours overtime)
    println("Salary for 20 days: $regularSalary €")
    println("Salary for 25 days: $overtimeSalary €")

    // Test calculateInternetFee
    val regularFee = calculateInternetFee(45)
    val extraFee = calculateInternetFee(60)
    println("Internet fee for 45 GB: $regularFee €")
    println("Internet fee for 60 GB: $extraFee €")

    // Test convertToFahrenheit
    val freezingInF = convertToFahrenheit(0.0)
    val bodyTempInF = convertToFahrenheit(37.0)
    println("0°C in Fahrenheit: $freezingInF°F")
    println("37°C in Fahrenheit: $bodyTempInF°F")

    // Test calculateRectanglePerimeter
    val squarePerimeter = calculateRectanglePerimeter(5.0, 5.0)
    val rectanglePerimeter = calculateRectanglePerimeter(4.0, 6.0)
    println("Perimeter of a 5x5 square: $squarePerimeter units")
    println("Perimeter of a 4x6 rectangle: $rectanglePerimeter units")

    // Test calculateFactorial
    val factorial5 = calculateFactorial(5)
    val factorial10 = calculateFactorial(10)
    println("5! = $factorial5")
    println("10! = $factorial10")

    // Test countLetterA
    val countInBanana = countLetterA("banana")
    val countInAnagram = countLetterA("Anagram")
    println("Number of 'a's in 'banana': $countInBanana")
    println("Number of 'a's in 'Anagram': $countInAnagram")
}