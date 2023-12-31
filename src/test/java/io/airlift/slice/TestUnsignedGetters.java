/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.airlift.slice;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestUnsignedGetters
{
    private static Slice createTestData()
    {
        Slice slice = Slices.allocate(8);
        slice.fill((byte) 0xA5);
        return slice;
    }

    @Test
    public void testUnsignedByte()
    {
        int expected = 0xA5;
        assertThat(expected > 0).isTrue();
        assertThat(createTestData().getUnsignedByte(0)).isEqualTo((short) expected);
    }

    @Test
    public void testUnsignedShort()
    {
        int expected = 0xA5A5;
        assertThat(expected > 0).isTrue();
        assertThat(createTestData().getUnsignedShort(0)).isEqualTo(expected);
    }

    @Test
    public void testUnsignedInt()
    {
        long expected = 0xA5A5A5A5L;
        assertThat(expected > 0).isTrue();  // make sure we didn't forget the L in the constant above
        assertThat(createTestData().getUnsignedInt(0)).isEqualTo(expected);
    }

    protected Slice allocate(int size)
    {
        return Slices.allocate(size);
    }
}
