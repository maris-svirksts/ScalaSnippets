package AdventOfCode

import scala.annotation.tailrec

object SumTo2020 extends App {
  // List(933, 1087, 1014171)
  // List(59, 1395, 566, 46584630)

  val input: List[Int] = List(1935, 1956, 1991, 1425, 1671, 1537, 1984, 1569, 1873, 1840, 1720, 1937, 1823, 1625, 1727, 1812, 1714, 1900, 1939, 1931, 1951,
    1756, 1942, 1611, 1979, 1930, 1996, 2000, 1544, 1780, 1687, 1760, 1836, 1814, 1691, 1817, 1964, 1899, 1577, 1547, 866, 1560, 1988, 1601, 1970, 1738,
    1507, 1667, 1851, 1933, 1515, 1856, 1969, 1860, 1801, 2007, 1866, 1800, 1749, 1843, 1711, 1495, 1905, 763, 1672, 1858, 1987, 1492, 1849, 1993, 1737,
    1874, 1658, 1810, 1665, 1768, 1950, 1879, 1816, 1868, 1995, 1763, 1783, 1833, 1968, 1847, 1748, 1725, 1891, 1755, 286, 1976, 1977, 1655, 1808, 1986,
    1779, 1861, 1953, 1888, 1792, 1811, 1872, 1790, 1839, 1985, 1827, 1842, 1925, 1735, 1635, 1821, 1820, 1973, 1531, 1770, 59, 1846, 1932, 1907, 1730,
    933, 1395, 1753, 1751, 361, 1530, 1782, 1087, 1589, 1929, 1795, 1815, 1732, 1765, 1877, 1722, 526, 1709, 1789, 1892, 1913, 1662, 1809, 1670, 1947,
    1835, 1587, 1758, 1982, 2009, 1757, 670, 1983, 1524, 1878, 1796, 1952, 566, 1922, 1882, 1870, 1799, 1731, 1724, 1805, 2003, 1596, 1566, 1853, 1911,
    1857, 1739, 1744, 1627, 1729, 1745, 1845, 1582, 1884, 1883, 1941, 1764, 1685, 1791, 1837, 1697, 1742, 1781, 1948, 1876, 1989, 1643, 1871, 1906, 1726,
    1958, 1502, 1927, 1946)

  val target: Int = 2020

  @tailrec
  def loop_p1(currentElement: Int, secondElementId: Int, list: List[Int]): List[Int] = {
    if(list.isEmpty) List(-1)
    else if(currentElement + list(secondElementId) == target) List(currentElement, list(secondElementId), currentElement * list(secondElementId))
    else if(secondElementId < list.length - 1) loop_p1(currentElement, secondElementId + 1, list)
    else loop_p1(list.head, 0, list.tail)
  }

  val tailrecResult_p1 = loop_p1(input.head, 0, input.tail)
  println("tailrecResult_p1: " + tailrecResult_p1)

  @tailrec
  def loop_p2(currentElement: Int, secondElementId: Int, thirdElementId: Int, list: List[Int]): List[Int] = {
    if(list.isEmpty) List(-1)
    else if(currentElement + list(secondElementId)  + list(thirdElementId) == target) List(currentElement, list(secondElementId), list(thirdElementId), currentElement * list(secondElementId) * list(thirdElementId))
    else if(thirdElementId < list.length - 1) loop_p2(currentElement, secondElementId, thirdElementId + 1, list)
    else if(secondElementId < list.length - 2) loop_p2(currentElement, secondElementId + 1, secondElementId + 2, list)
    else loop_p2(list.head, 0, 1, list.tail)
  }

  val tailrecResult_p2 = loop_p2(input.head, 0, 1, input.tail)
  println("tailrecResult_p2: " + tailrecResult_p2)

  val forResult_p1 = for{
    i <- input.indices
    j <- (i + 1) until input.length
    if(input(i) + input(j) == target)
  } yield(input(i), input(j), input(i) * input(j))

  println("forResult_p1: " + forResult_p1)

  val forResult_p2 = for{
    i <- input.indices
    j <- (i + 1) until input.length
    z <- (j + 1) until input.length
    if(input(i) + input(j) + input(z) == target)
  } yield(input(i), input(j), input(z), input(i) * input(j) * input(z))

  println("forResult_p2: " + forResult_p2)
}
