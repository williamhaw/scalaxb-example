package com.williamhaw.scalaxb.example

import org.scalatest.{Matchers, WordSpec}

import scala.xml.NodeSeq
import scala.xml.Utility.trim

class AddressSpec extends WordSpec with Matchers{

  val xmlAddress: NodeSeq = <shipTo xmlns="http://www.example.com/IPO">
    <name>Foo</name>
    <street>1537 Paper Street</street>
    <city>Wilmington</city>
  </shipTo>

  val scalaAddress = Address("Foo", "1537 Paper Street", "Wilmington")

  "Serialized Address matches expected address" in {

    val actualAddress: Address = scalaxb.fromXML[Address](xmlAddress)

    actualAddress shouldEqual scalaAddress
  }

  "Deserialized Address matches xml" in {

    val actualXml: NodeSeq = scalaxb.toXML[Address](scalaAddress, None, Some("shipTo"), defaultScope)

    actualXml.map(trim) shouldEqual xmlAddress.map(trim)
  }
}
