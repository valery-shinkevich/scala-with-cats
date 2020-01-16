package scala_with_cats.part_1.json

import scala_with_cats.UnitSpec
import JsonSyntax._
import JsonWriterInstances._

class JsonWriterInstancesTest extends UnitSpec {

  behavior.of("JsonWriterInstancesTest")

  it should "stringWriter" in {

    "string".toJson should be(JsString("string"))
  }

  it should "personWriter" in {

    Person(name = "John", "john@x.com").toJson should be(
      JsObject(Map("name" -> JsString("John"), "email" -> JsString("john@x.com")))
    )

  }

  it should "optionWriter" in {
    Option("string").toJson should be(JsString("string"))
    (None: Option[String]).toJson should be(JsNull)
  }

}
