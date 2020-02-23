package ph.nard.designpatterns.creational.factory

import scala.util.Random

object LockHandlerMain {

  def main(args: Array[String]): Unit = {
    // Instantiate LockHandler without knowing that it's really a FileBaseLockHandler
    val lockHandler = LockHandler()
    val key1 = s"test-${Random.alphanumeric.take(5).mkString}.lck"

    val thread1 = new Thread() {
      override def run(): Unit = {
        // Success(true)
        println(lockHandler.acquireLock(key1))
      }
    }

    thread1.start()

    // Try to throttle start of thread2
    Thread.sleep(1000)

    val thread2 = new Thread() {
      override def run(): Unit = {
        // Failure(java.lang.IllegalStateException: Can't release lock from different thread.)
        println(lockHandler.releaseLock(key1))
      }
    }

    // This should return an IllegalStateException
    thread2.start()

    val key2 = s"test-${Random.alphanumeric.take(5).mkString}.lck"
    // Success(true)
    println(lockHandler.acquireLock(key2))
    // Success(true)
    println(lockHandler.releaseLock(key2))
  }
}
