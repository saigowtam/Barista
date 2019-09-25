package com.schibsted.spain.barista.sample

import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.BaristaChipAssertions.assertAnyChipSelected
import com.schibsted.spain.barista.BaristaChipAssertions.assertChipsSelected
import com.schibsted.spain.barista.assertion.BaristaCheckedAssertions.assertChecked
import com.schibsted.spain.barista.assertion.BaristaCheckedAssertions.assertUnchecked
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.sample.util.SpyFailureHandlerRule
import org.junit.Rule
import org.junit.Test

class ChipsTest {

  @get:Rule
  var activityRule = ActivityTestRule(ChipsActivity::class.java)

  @get:Rule
  var spyFailureHandlerRule = SpyFailureHandlerRule()

  @Test
  fun assertCheckedChip() {
    assertChecked(R.id.checkedChip)

    spyFailureHandlerRule.assertNoEspressoFailures()
  }

  @Test
  fun assertUncheckedChip() {
    assertUnchecked(R.id.uncheckedChip)

    spyFailureHandlerRule.assertNoEspressoFailures()
  }

  @Test
  fun checkOnChipOnSingleChoiceChipGroup_hasOnlyOneSelectedChip() {
    clickOn(R.id.chip1)

    assertAnyChipSelected(R.id.singleSelectionChildGroup)

    spyFailureHandlerRule.assertNoEspressoFailures()
  }

  @Test
  fun checkOnChipOnChipGroup_hasChipsSelected() {
    clickOn(R.id.multiChip1)
    clickOn(R.id.multiChip2)

    assertChipsSelected(R.id.multiChip1, R.id.multiChip2)

    spyFailureHandlerRule.assertNoEspressoFailures()
  }
}