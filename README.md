## Sbt Access Issue

Loading this up in sbt and running it gives you the following error.  I've
tried changing the classloader strategy to `ScalaInstance` and `Flat` and
neither make a difference.  Changing the scala version to `3.3.3` doesn't seem
to make a difference however reverting back to `2.13.14` allows the code to run
as expected.

I'm not sure if there is some other option I need to set or this is
a legitimate bug with sbt or scala.

#### Error message

```
Exception in thread "sbt-bg-threads-32" java.lang.IllegalAccessError: Error running public static void Run.main(java.lang.String[]).
java.lang.IllegalAccessError: failed to access class org.apache.commons.io.input.BoundedInputStream$AbstractBuilder from class Run$ (org.apache.commons.io.input.BoundedInputStream$AbstractBuilder and Run$ are in unnamed module of loader sbt.internal.LayeredClassLoader @248cdc34)
If using a layered classloader, this can occur if jvm package private classes are accessed across layers. This can be fixed by changing to the Flat or ScalaInstance class loader layering strategies.
	at sbt.Run.invokeMain(Run.scala:153)
	at sbt.Run.execute$1(Run.scala:94)
	at sbt.Run.$anonfun$runWithLoader$5(Run.scala:121)
	at sbt.Run$.executeSuccess(Run.scala:187)
	at sbt.Run.runWithLoader(Run.scala:121)
	at sbt.Defaults$.$anonfun$bgRunTask$6(Defaults.scala:2038)
	at sbt.Defaults$.$anonfun$termWrapper$2(Defaults.scala:1977)
	at scala.runtime.java8.JFunction0$mcV$sp.apply(JFunction0$mcV$sp.java:23)
	at scala.util.Try$.apply(Try.scala:213)
	at sbt.internal.BackgroundThreadPool$BackgroundRunnable.run(DefaultBackgroundJobService.scala:367)
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1144)
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:642)
	at java.base/java.lang.Thread.run(Thread.java:1583)
```
