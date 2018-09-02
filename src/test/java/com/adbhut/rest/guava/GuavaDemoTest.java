package com.adbhut.rest.guava;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Strings;

@RunWith(JUnit4.class)
public class GuavaDemoTest {

	private String userName = "adbhutrai";

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testFirstNotNullGauva() {
		Integer first = MoreObjects.firstNonNull(3, null);
		Integer second = MoreObjects.firstNonNull(null, 9);
		System.out.println("first:" + first + ", second:" + second);
		assertThat(first).isEqualTo(3);
		assertThat(second).isEqualTo(9);
	}

	@Test
	public void testNullInStrings() {
		boolean isEmpty = Strings.isNullOrEmpty("");
		boolean isNull = Strings.isNullOrEmpty(null);
		System.out.println("isEmpty:" + isEmpty + ", isNull:" + isNull);
		assertThat(isEmpty).isTrue();
		assertThat(isNull).isTrue();
	}

	@Test
	public void testNotNullInStrings() {
		boolean isEmpty = Strings.isNullOrEmpty(" ");
		boolean isNull = Strings.isNullOrEmpty(" ddd");
		System.out.println("isEmpty:" + isEmpty + ", isNull:" + isNull);
		assertThat(isEmpty).isFalse();
		assertThat(isNull).isFalse();
	}

	@Test
	public void testPreconditionsNotNull() {
		this.thrown.expect(NullPointerException.class);
		checkNotNull(null);

	}

	@Test
	public void testPreconditionsCheckState() {
		this.thrown.expect(IllegalStateException.class);
		checkState(Strings.isNullOrEmpty("test"));

	}

	@Test
	public void testPreconditionsCheckArgument() {
		this.thrown.expect(IllegalArgumentException.class);
		this.thrown.expectMessage("username testuser did not match with userName of class");
		checkArgument(this.userName.equals("testuser"), "username %s did not match with userName of class", "testuser");
	}

	@Test
	public void testObjectsEquality() {
		assertThat(Objects.equal("a", "a")).isTrue();

		assertThat(Objects.equal("a", null)).isFalse();

		assertThat(Objects.equal(null, "a")).isFalse();

		assertThat(Objects.equal(null, null)).isTrue();

	}
}
