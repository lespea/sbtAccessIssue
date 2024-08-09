import org.apache.commons.io.input.BoundedInputStream

import java.io.ByteArrayInputStream

object Main {

  def main(args: Array[String]): Unit = {
    val in = new ByteArrayInputStream("this is a string".getBytes)

    val is = BoundedInputStream
      .builder()
      .setInputStream(in)
      .setCount(0)
      .setMaxCount(12)
      .get()

    println(new String(is.readAllBytes()))
  }

}
